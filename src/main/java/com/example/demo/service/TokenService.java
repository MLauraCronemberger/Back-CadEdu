package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.domain.dto.users.UsersCreateDTO;
import com.example.demo.domain.dto.users.UsersLoginRequestDTO;
import com.example.demo.domain.dto.users.UsersLoginResponseDTO;
import com.example.demo.domain.dto.users.UsersResponseDTO;

public interface TokenService {
	UsersResponseDTO cadastro(@RequestBody UsersCreateDTO createUser);
	ResponseEntity<UsersLoginResponseDTO> login(@RequestBody UsersLoginRequestDTO loginRequest);

}
