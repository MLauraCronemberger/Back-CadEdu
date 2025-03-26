package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Serie;
import com.example.demo.repository.SerieRepository;

@RestController
@RequestMapping(value="/serie")
public class SerieController {
	
	@Autowired
	private SerieRepository repository;
	
//	Para salvar várias serie de uma vez o meu requestbody deveria enviar uma lista do tipo serie
	@PostMapping(value="/cadastrar")
	public Serie insert(@RequestBody Serie serie) {
		Serie serieCadastrada = repository.save(serie);
		return serieCadastrada;
	}
	
	@GetMapping(value="/cadastradas")
	public List<Serie> findAll(){
		List<Serie> series = repository.findAll();
		return series;
	}
	
	@GetMapping(value="/{id}")
	public Serie findById(@PathVariable Long id) {
		Serie serie = repository.findById(id).get();
		return serie;
	}
	
	@DeleteMapping(value="/deletar-{id}")
	public String deleteById(@PathVariable Long id) {
		repository.deleteById(id);
		return "Serie Deletada";
		
	}
	
	@PutMapping(value="editar-{id}")
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
