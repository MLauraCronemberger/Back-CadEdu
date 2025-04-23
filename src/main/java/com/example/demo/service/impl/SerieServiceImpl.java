package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.Serie;
import com.example.demo.domain.dto.serie.SerieCreateDTO;
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
	public SerieResponseDTO create(SerieCreateDTO serie) {
		Serie serieCadastrada = repository.save(mapper.paraEntidade(serie));
		return mapper.paraDTO(serieCadastrada);
	}

	@Override
	public List<SerieResponseDTO> findAll() {
		List<Serie> series = repository.findAll();
		
		return mapper.paraListDTO(series);
	}
	
	@Override
	public SerieResponseDTO findById(@PathVariable Long id) {
		Serie serieCadastrada = repository.findById(id).get();
		return mapper.paraDTO(serieCadastrada);
	}
	
	@Override
	public String deleteById(@PathVariable Long id) {
		
		repository.deleteById(id);
		return "Serie Deletada";
	}
	
	@Override
	public SerieResponseDTO update(@PathVariable Long id, SerieCreateDTO editarSerie) {
		Serie serieEditada = repository.findById(id).get();
		serieEditada.setSerie(editarSerie.getSerie());
		serieEditada.setNivelEnsino(editarSerie.getNivelEnsino());
		serieEditada.setTurma(editarSerie.getTurma());
		serieEditada.setTurno(editarSerie.getTurno());
		
		repository.save(serieEditada);
		
		return mapper.paraDTO(serieEditada);
		
	}
	
	@Override
	public List<SerieResponseDTO> pesquisa(@PathVariable int serie){
		return mapper.paraListDTO(repository.buscarSerie(serie));
	}


	
	

}
