package com.example.demo.domain.dto.users;

public record UsersLoginResponseDTO(String accessToken, Long expiresIn) {
	
	//ExpiresIn é para quantos segundos o seu token vai expirar

}
