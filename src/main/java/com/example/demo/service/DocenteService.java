package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.Docente;
import com.example.demo.domain.dto.docente.DocenteResponseDTO;

public interface DocenteService {
	DocenteResponseDTO create(Docente docente);
	List<DocenteResponseDTO> findAll();
	DocenteResponseDTO findById(@PathVariable Long id);
	String deleteById(@PathVariable Long id);
	DocenteResponseDTO update(@PathVariable Long id, Docente editarDocente);

}
