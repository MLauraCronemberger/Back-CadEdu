package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.Aluno;
import com.example.demo.domain.dto.aluno.AlunoResponseDTO;


public interface AlunoService {
	AlunoResponseDTO create(Aluno aluno);
	List<AlunoResponseDTO> findAll();
	AlunoResponseDTO findById(@PathVariable Long id);
	String deleteById(@PathVariable Long id);
	AlunoResponseDTO update(@PathVariable Long id, Aluno editarAluno);

}
