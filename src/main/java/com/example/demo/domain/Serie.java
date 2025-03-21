package com.example.demo.domain;

public class Serie {
	
	private int serie;
	private String nivelEnsino;
	private String turma;
	private String turno;
	
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
	
	public Serie(int serie, String nivelEnsino, String turma, String turno) {
		super();
		this.serie = serie;
		this.nivelEnsino = nivelEnsino;
		this.turma = turma;
		this.turno = turno;
	}
	
	



}
