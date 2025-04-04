package com.example.demo.domain.dto.disciplina;

import com.example.demo.domain.dto.serie.SerieCreateDTO;


import jakarta.validation.constraints.NotBlank;


public class DisciplinaCreateDTO {
	
	@NotBlank(message="O campo de disciplina precisa ser preenchido.")
	private String disc;
	
	@NotBlank(message="O campo de carga horária precisa ser preenchido.")
	private String ch;
	
	private SerieCreateDTO serie;

	public String getDisc() {
		return disc;
	}

	public void setDisc(String disc) {
		this.disc = disc;
	}

	public String getCh() {
		return ch;
	}

	public void setCh(String ch) {
		this.ch = ch;
	}

	public SerieCreateDTO getSerie() {
		return serie;
	}

	public void setSerie(SerieCreateDTO serie) {
		this.serie = serie;
	}
	
	

}
