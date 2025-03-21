package com.example.demo.domain;

import jakarta.persistence.Entity;

@Entity
public class Aluno extends Pessoa {
	
	private String responsavel;
	private String foto;
	private String nivelEnsino;
	private Serie serie;
//	private Serie turma;
	//private Serie turno;
	
	
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getNivelEnsino() {
		return nivelEnsino;
	}
	public void setNivelEnsino(String nivelEnsino) {
		this.nivelEnsino = nivelEnsino;
	}
	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	
	
	public Aluno(String nome, String cpf, String datnasc, String responsavel, String foto, String nivelEnsino,
			Serie serie) {
		super(nome, cpf, datnasc);
		this.responsavel = responsavel;
		this.foto = foto;
		this.nivelEnsino = nivelEnsino;
		this.serie = serie;

	}

	}

			
	

	
	
	

	
	

	


