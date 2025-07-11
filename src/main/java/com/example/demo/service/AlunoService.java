package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.dto.aluno.AlunoCreateDTO;
import com.example.demo.domain.dto.aluno.AlunoResponseDTO;



public interface AlunoService {
	AlunoResponseDTO create(AlunoCreateDTO aluno);
	List<AlunoResponseDTO> findAll();
	AlunoResponseDTO findById(@PathVariable Long id);
	String deleteById(@PathVariable Long id);
	AlunoResponseDTO update(@PathVariable Long id, AlunoCreateDTO editarAluno);
	List<AlunoResponseDTO> Pesquisa(String nome);

}
