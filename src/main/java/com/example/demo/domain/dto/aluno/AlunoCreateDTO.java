package com.example.demo.domain.dto.aluno;

import com.example.demo.domain.dto.serie.SerieResponseDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AlunoCreateDTO {
	
	@NotBlank(message="O campo nome deve ser preenchido")
	private String nome;
	
	@Size(min=14, max=14, message="O cpf deve estar no formato correto.")
	private String cpf;
	
	@NotBlank(message="O campo data de nascimento deve ser preenchido.")
	private String datnasc;
	
	@NotBlank(message="O campo data de responsavel deve ser preenchido.")
	private String responsavel;
	
	@NotBlank(message="O campo foto deve ser preenchido.")
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
