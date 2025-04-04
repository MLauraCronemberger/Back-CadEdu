package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.Disciplina;
import com.example.demo.domain.dto.disciplina.DisciplinaCreateDTO;
import com.example.demo.domain.dto.disciplina.DisciplinaResponseDTO;

public interface DisciplinaService {
	DisciplinaResponseDTO create(DisciplinaCreateDTO disciplina);
	List<DisciplinaResponseDTO> findAll();
	DisciplinaResponseDTO findById(@PathVariable Long id);
	String deleteById(@PathVariable Long id);
	DisciplinaResponseDTO update(@PathVariable Long id, DisciplinaCreateDTO editarDisciplina);
	List<DisciplinaResponseDTO> DisciplinasSemDocente();
	List<DisciplinaResponseDTO> DisciplinaEditar(@PathVariable Long id);
	
}

