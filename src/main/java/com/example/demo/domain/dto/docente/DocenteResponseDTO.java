package com.example.demo.domain.dto.docente;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.Disciplina;
import com.example.demo.domain.Serie;

public class DocenteResponseDTO {
	private String nome;
	private String cpf;
	private String datnasc;
	private Long id;
	private String tel;
	private String email;
	private String cargo;
//	private Disciplina disciplina;
	
//	Quero que apareça tudo de serie, menos docentes
//	private List<Serie> series = new ArrayList<>();
	
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
//	public Disciplina getDisciplina() {
//		return disciplina;
//	}
//	public void setDisciplina(Disciplina disciplina) {
//		this.disciplina = disciplina;
//	}
	

	
	
}
