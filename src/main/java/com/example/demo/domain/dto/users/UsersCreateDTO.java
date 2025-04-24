package com.example.demo.domain.dto.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsersCreateDTO {
	@NotBlank(message="O campo nome deve ser preenchido")
	private String nome;
	
	@Size(min=14, max=14, message="O cpf deve estar no formato correto.")
	private String cpf;
	
	@NotBlank(message="O campo data de nascimento deve ser preenchido.")
	private String datnasc;
	
	@NotBlank(message="O campo de email precisa ser preenchido.")
	private String email;
	
	@NotBlank(message="O campo de senha precisa ser preenchido.")
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDatnasc() {
		return datnasc;
	}

	public void setDatnasc(String datnasc) {
		this.datnasc = datnasc;
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
	
	

}
