package com.example.demo.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Users;
import com.example.demo.domain.dto.users.UsersLoginRequestDTO;
import com.example.demo.domain.dto.users.UsersLoginResponseDTO;
import com.example.demo.repository.UsersRepository;

@RestController
public class TokenController {
	
	@Autowired
	private UsersRepository repository;
	
	private final JwtEncoder jwtEncoder;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public TokenController(JwtEncoder jwtEncoder, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.jwtEncoder = jwtEncoder;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
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
