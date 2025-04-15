package com.example.demo.domain.dto.serie;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SerieCreateDTO {
	
	@NotNull(message= "A serie não pode estar em branco.")
	@Min(value = 1, message = "O campo de série não pode estar vazio.")
	private int serie;
	
	@NotBlank(message= "O campo de nivel de ensino não pode estar vazio.")	
	private String nivelEnsino;
	
	@NotBlank(message= "O campo da turma não pode estar vazio.")
	private String turma;
	
	@NotBlank(message= "O campo do turno não pode estar vazio.")
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
	
	

}
