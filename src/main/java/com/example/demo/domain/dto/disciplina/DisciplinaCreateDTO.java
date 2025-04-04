package com.example.demo.domain.dto.disciplina;

import com.example.demo.domain.Serie;
import com.example.demo.domain.dto.serie.SerieCreateDTO;
import com.example.demo.domain.dto.serie.SerieResponseDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class DisciplinaCreateDTO {
	
	@NotBlank(message="O campo de disciplina precisa ser preenchido.")
	private String disc;
	
	@NotBlank(message="O campo de carga horária precisa ser preenchido.")
	private String ch;
	
	@NotNull(message="O campo de série precisa ser preenchido.")
	private Serie serie;

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

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	

}
