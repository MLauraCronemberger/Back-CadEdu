package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Serie;
import com.example.demo.domain.dto.serie.SerieResponseDTO;

public interface SerieService {
	List<SerieResponseDTO> findAll ();
	SerieResponseDTO create(Serie serie);


}
