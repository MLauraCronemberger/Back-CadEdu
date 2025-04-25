package com.example.demo.controller;

import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
	
	private final JwtEncoder jwtEncoder;
	
	public TokenController(JwtEncoder jwtEncoder) {
		this.jwtEncoder = jwtEncoder;
	}
	
//	@PostMapping("/login")
//	public ResponseEntity<UsersLoginDTO>

}
