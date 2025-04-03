package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;


//
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Serie {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private int serie;
	private String nivelEnsino;
	private String turma;
	private String turno;
	
	@ManyToMany(mappedBy= "series")
	private List<Docente> docentes = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getSerie() {
		return serie;
	}
	public void setSerie(int serie) {
		this.serie = serie;
	}
	public String getNivelEnsino() {
		return nivelEnsino;
	}
	public void setNivelEnsino(String nivelEnsino) {
		this.nivelEnsino = nivelEnsino;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	
	public List<Docente> getDocentes() {
		return docentes;
	}
	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}
	public Serie() {
		super();
	}
	
	
	public Serie(Long id, int serie, String nivelEnsino, String turma, String turno) {
		super();
		this.id = id;
		this.serie = serie;
		this.nivelEnsino = nivelEnsino;
		this.turma = turma;
		this.turno = turno;
	}
	
	
	
	



}
