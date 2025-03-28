package com.example.demo.domain.dto.aluno;

import com.example.demo.domain.dto.serie.SerieResponseDTO;

public class AlunoResponseDTO {
	private String nome;
	private String cpf;
	private String datnasc;
	private Long id;
	private String responsavel;
	private String foto;
	private SerieResponseDTO serie;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDatnasc() {
		return datnasc;
	}
	public void setDatnasc(String datnasc) {
		this.datnasc = datnasc;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public SerieResponseDTO getSerie() {
		return serie;
	}
	public void setSerie(SerieResponseDTO serie) {
		this.serie = serie;
	}
	

}
