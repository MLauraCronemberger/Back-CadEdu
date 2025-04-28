package com.example.demo.domain;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.domain.dto.users.UsersLoginRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users extends Pessoa {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String email;
	
	private String senha;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	
	
	public Users(String nome, String cpf, String datnasc, Long id, String email, String senha) {
		super(nome, cpf, datnasc);
		this.id = id;
		this.email = email;
		this.senha = senha;
	}
	
	public boolean isLoginCorrect(UsersLoginRequestDTO loginRequest, PasswordEncoder passwordEncoder) {
		
		return passwordEncoder.matches(loginRequest.senha(), this.senha);
		
	}
	
	
	
	
	

}
