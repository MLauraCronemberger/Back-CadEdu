package com.example.demo.domain;

import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class Pessoa {
	
	private String nome;
	private String cpf;
	private String datnasc;
	
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
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String cpf, String datnasc) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.datnasc = datnasc;
	}

	

}
