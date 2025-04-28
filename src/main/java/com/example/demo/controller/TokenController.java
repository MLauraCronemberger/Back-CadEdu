package com.example.demo.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.domain.Aluno;
import com.example.demo.domain.Serie;
import com.example.demo.domain.Users;
import com.example.demo.domain.dto.users.UsersCreateDTO;
import com.example.demo.domain.dto.users.UsersLoginRequestDTO;
import com.example.demo.domain.dto.users.UsersLoginResponseDTO;
import com.example.demo.domain.dto.users.UsersResponseDTO;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.mapper.UsersMapper;

@RestController
public class TokenController {
	
	@Autowired
	private UsersRepository repository;
	
	private final UsersMapper mapper = UsersMapper.INSTANCE;
	
	private final JwtEncoder jwtEncoder;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public TokenController(JwtEncoder jwtEncoder, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.jwtEncoder = jwtEncoder;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@PostMapping("/cadastro")
	public UsersResponseDTO cadastro(@RequestBody UsersCreateDTO createUser){
		var userFromDb= repository.findByEmail(createUser.getEmail());
		if (userFromDb.isPresent()) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		var user = new Users();
		user.setNome(createUser.getNome());
		user.setCpf(createUser.getCpf());
		user.setDatnasc(createUser.getDatnasc());
		user.setEmail(createUser.getEmail());
		user.setSenha(bCryptPasswordEncoder.encode(createUser.getSenha()));
		
		repository.save(user);
		
		return mapper.paraResponseDTO(user);
		
	}
	
//	@PostMapping("/cadastro")
//	public String cadastro(){
//		return "Chegou!";
//	}
	
	@PostMapping("/login")
	public ResponseEntity<UsersLoginResponseDTO> login(@RequestBody UsersLoginRequestDTO loginRequest){
		var email= repository.findByEmail(loginRequest.email());
		
		if(email.isEmpty() || !email.get().isLoginCorrect(loginRequest, bCryptPasswordEncoder)) {
			throw new BadCredentialsException("O e-mail ou a senha estão incorretos.");
		} 
		
		var now = Instant.now();
		
		var expiresIn = 400L;
		
		var claims = JwtClaimsSet.builder()
				.issuer("mybackend")
				.subject(email.get().getId().toString())
				.issuedAt(now)
				.expiresAt(now.plusSeconds(expiresIn))
				.build();
		
		var jwtValue= jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	
		return ResponseEntity.ok(new UsersLoginResponseDTO(jwtValue, expiresIn));
				
		
		
	}

}
