package com.example.demo.domain.dto.users;

import jakarta.validation.constraints.NotBlank;

public class UsersLoginDTO {
	@NotBlank(message="O campo de email precisa ser preenchido.")
	private String email;
	
	@NotBlank(message="O campo de senha precisa ser preenchido.")
	private String senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
