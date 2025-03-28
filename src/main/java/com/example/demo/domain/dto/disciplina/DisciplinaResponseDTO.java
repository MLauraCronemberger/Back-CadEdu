package com.example.demo.domain.dto.disciplina;


import com.example.demo.domain.dto.serie.SerieResponseDTO;



public class DisciplinaResponseDTO {

	private Long id;
	private String disc;
	private String ch;
	

	private SerieResponseDTO serie;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


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


	public SerieResponseDTO getSerie() {
		return serie;
	}


	public void setSerie(SerieResponseDTO serie) {
		this.serie = serie;
	}
	
	
	

}
