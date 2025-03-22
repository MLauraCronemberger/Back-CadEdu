package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="informacoes_docentes")
public class Docente extends Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String tel;
	private String email;
	private String cargo;
	
	@OneToOne
	@JoinColumn(name="disciplina")
	private Disciplina disc;
	
//	falta o relacionamento manytomany, que ainda vou estudar um pouco antes de fazer
	private Serie serie;
	private Serie turno;
	
	
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
	
	
	public Docente(String nome, String cpf, String datnasc, Long id, String tel, String email, String cargo,
			Disciplina disc, Serie serie, Serie turno) {
		super(nome, cpf, datnasc);
		this.id = id;
		this.tel = tel;
		this.email = email;
		this.cargo = cargo;
		this.disc = disc;
		this.serie = serie;
		this.turno = turno;
	}
	

}
