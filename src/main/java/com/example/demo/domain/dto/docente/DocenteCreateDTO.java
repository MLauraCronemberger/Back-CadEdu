package com.example.demo.domain.dto.docente;

import com.example.demo.domain.dto.disciplina.DisciplinaResponseDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DocenteCreateDTO {
	
	@NotBlank(message="O campo nome deve ser preenchido")
	private String nome;
	
	@Size(min=11, max=14, message="O cpf deve estar no formato correto.")
	private String cpf;
	
	@NotBlank(message="O campo data de nascimento deve ser preenchido.")
	private String datnasc;
	
	@NotBlank(message="O campo telefon deve ser preenchido.")
	private String tel;
	
	@Email(message="O e-mail deve ser inserido no formato correto")
	private String email;
	
	@NotBlank(message="O campo de cargo deve ser preenchido.")
	private String cargo;
	
	private DisciplinaResponseDTO disciplina;
	
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public DisciplinaResponseDTO getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(DisciplinaResponseDTO disciplina) {
		this.disciplina = disciplina;
	}
	
	

}
