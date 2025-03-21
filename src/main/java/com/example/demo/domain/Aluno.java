package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "informacoes_aluno")
public class Aluno extends Pessoa {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String responsavel;
	private String foto;
	private String nivelEnsino;
	
	@ManyToOne
	@JoinColumn(name="id_serie")
	private Serie infoserie;
	

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
	public String getNivelEnsino() {
		return nivelEnsino;
	}
	public void setNivelEnsino(String nivelEnsino) {
		this.nivelEnsino = nivelEnsino;
	}
	public Serie getinfoserie() {
		return infoserie;
	}
	public void setinfoserie(Serie infoserie) {
		this.infoserie = infoserie;
	}
	
	public Aluno(String nome, String cpf, String datnasc, Long id, String responsavel, String foto, String nivelEnsino,
			Serie infoserie) {
		super(nome, cpf, datnasc);
		this.id = id;
		this.responsavel = responsavel;
		this.foto = foto;
		this.nivelEnsino = nivelEnsino;
		this.infoserie = infoserie;
	}


	}

			
	

	
	
	

	
	

	


