package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.Serie;
import com.example.demo.domain.dto.serie.SerieResponseDTO;

public interface SerieService {
	List<SerieResponseDTO> findAll ();
	SerieResponseDTO create(Serie serie);
	SerieResponseDTO findById(@PathVariable Long id);
	String deleteById(@PathVariable Long id);
	SerieResponseDTO update(@PathVariable Long id, Serie editarSerie);


}
