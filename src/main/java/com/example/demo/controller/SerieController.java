package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Serie;
import com.example.demo.domain.dto.serie.SerieResponseDTO;
import com.example.demo.repository.SerieRepository;
import com.example.demo.service.impl.SerieServiceImpl;
import com.example.demo.service.mapper.SerieMapper;

@RestController
@RequestMapping(value="/serie")
@CrossOrigin("*")
public class SerieController {
	
	@Autowired
	private SerieServiceImpl service;
	private SerieRepository repository;
	private final SerieMapper mapper = SerieMapper.INSTANCE;
	
//	Para salvar várias series de uma vez o meu requestbody deveria enviar uma lista do tipo serie
	@PostMapping(value="/cadastrar")
	public ResponseEntity<Serie> insert(@RequestBody Serie serie) {
		Serie serieCadastrada = repository.save(serie);
		return ResponseEntity.ok(serieCadastrada);
	}
	
	@GetMapping(value="/cadastradas")
	public ResponseEntity<List<SerieResponseDTO>> findAll(){
		return ResponseEntity.ok(service.findAll());
		
	}
	
	@GetMapping(value="/{id}")
	public SerieResponseDTO findById(@PathVariable Long id) {
		Serie serie = repository.findById(id).get();
		return mapper.paraDTO(serie);
	}
	
	@DeleteMapping(value="/deletar/{id}")
	public String deleteById(@PathVariable Long id) {
		repository.deleteById(id);
		return "Serie Deletada";
		
	}
	
	@PutMapping(value="/editar/{id}")
	public ResponseEntity<Serie> update(@PathVariable Long id, @RequestBody Serie serieEditada){
		Serie editarSerie= repository.findById(id).get();
		editarSerie.setSerie(serieEditada.getSerie());
		editarSerie.setNivelEnsino(serieEditada.getNivelEnsino());
		editarSerie.setTurma(serieEditada.getTurma());
		editarSerie.setTurno(serieEditada.getTurno());
		
		repository.save(editarSerie);
		
		return ResponseEntity.ok(editarSerie);
		
	}
	
//	@PutMapping(value="/editar-{id}")
//	public Serie update(@PathVariable Long id) {
//		Serie serie = repository.findById(id).get();
//		serie.setNivelEnsino("nilvee");
//		serie.setTurma("111");
//		
//		repository.save(serie);
//		
//		return serie;
//	}
	

}
