package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Docente extends Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String tel;
	private String email;
	private String cargo;
	
	@OneToOne
	@JoinColumn(name="id_disciplina")
	private Disciplina disciplina;
	
	@ManyToMany
	@JoinTable(
			name="docentes_serie",
			joinColumns= @JoinColumn(name="docente_id"),
			inverseJoinColumns = @JoinColumn(name = "serie_id")
			)
	private List<Serie> series = new ArrayList<>();
	
	
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
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public List<Serie> getSeries() {
		return series;
	}
	public void setSeries(List<Serie> series) {
		this.series = series;
	}
	public Docente(){
	}
	
	public Docente(String nome, String cpf, String datnasc, Long id, String tel, String email, String cargo,
			Disciplina disciplina) {
		super(nome, cpf, datnasc);
		this.id = id;
		this.tel = tel;
		this.email = email;
		this.cargo = cargo;
		this.disciplina = disciplina;
	}
	

}
