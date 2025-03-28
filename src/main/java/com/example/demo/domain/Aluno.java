package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Aluno extends Pessoa {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String responsavel;
	private String foto;
	
	@ManyToOne
	@JoinColumn(name="id_serie")
	private Serie serie;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
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
	
	public Serie getserie() {
		return serie;
	}
	public void setserie(Serie serie) {
		this.serie = serie;
	}
	
	
	
	public Aluno() {
	
	}
	
	public Aluno(String nome, String cpf, String datnasc, Long id, String responsavel, String foto,
			Serie serie) {
		super(nome, cpf, datnasc);
		this.id = id;
		this.responsavel = responsavel;
		this.foto = foto;
		this.serie = serie;
	}


	}

			
	

	
	
	

	
	

	


