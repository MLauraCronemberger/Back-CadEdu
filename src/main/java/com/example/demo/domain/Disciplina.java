package com.example.demo.domain;

public class Disciplina {
	
	private String disc;
	private String ch;
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

	public Disciplina(String disc, String ch, Serie serie) {
		super();
		this.disc = disc;
		this.ch = ch;
		this.serie = serie;
	}
	


}
