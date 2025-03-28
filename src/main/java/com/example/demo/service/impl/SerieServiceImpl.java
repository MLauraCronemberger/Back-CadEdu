package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Serie;
import com.example.demo.domain.dto.serie.SerieResponseDTO;
import com.example.demo.repository.SerieRepository;
import com.example.demo.service.SerieService;
import com.example.demo.service.mapper.SerieMapper;

@Service
public class SerieServiceImpl implements SerieService{
	
	@Autowired
	private SerieRepository repository;
	private final SerieMapper mapper = SerieMapper.INSTANCE;

	@Override
	public List<SerieResponseDTO> findAll() {
		List<Serie> series = repository.findAll();
		
		return mapper.paraListDTO(series);
	}

	@Override
	public SerieResponseDTO create(Serie serie) {
		Serie serieCadastrada = repository.save(serie);
		return mapper.paraDTO(serieCadastrada);
	}



}
