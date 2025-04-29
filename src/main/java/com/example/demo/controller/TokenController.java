package com.example.demo.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.dto.users.UsersCreateDTO;
import com.example.demo.domain.dto.users.UsersLoginRequestDTO;
import com.example.demo.domain.dto.users.UsersLoginResponseDTO;
import com.example.demo.domain.dto.users.UsersResponseDTO;
import com.example.demo.service.impl.TokenServiceImpl;


@RestController
public class TokenController {
	
	@Autowired
	private TokenServiceImpl service;
	
	
	@PostMapping("/cadastro")
	public UsersResponseDTO cadastro(@RequestBody UsersCreateDTO createUser){
		return service.cadastro(createUser);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<UsersLoginResponseDTO> login(@RequestBody UsersLoginRequestDTO loginRequest){
		return service.login(loginRequest);	
	}

}
