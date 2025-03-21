package com.example.demo.domain;

public class Docente extends Pessoa {
	
	private String tel;
	private String email;
	private String cargo;
	private Disciplina disc;
	private Serie serie;
	private Serie turno;
	
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
	public Disciplina getDisc() {
		return disc;
	}
	public void setDisc(Disciplina disc) {
		this.disc = disc;
	}
	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	public Serie getTurno() {
		return turno;
	}
	public void setTurno(Serie turno) {
		this.turno = turno;
	}
	
	
	public Docente(String nome, String cpf, String datnasc, String tel, String email, String cargo, Disciplina disc,
			Serie serie, Serie turno) {
		super(nome, cpf, datnasc);
		this.tel = tel;
		this.email = email;
		this.cargo = cargo;
		this.disc = disc;
		this.serie = serie;
		this.turno = turno;
	}
	
	

}
