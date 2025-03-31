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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Serie;
import com.example.demo.domain.dto.serie.SerieResponseDTO;
import com.example.demo.service.impl.SerieServiceImpl;

@RestController
@RequestMapping(value="/serie")
@CrossOrigin("*")
public class SerieController {
	
	@Autowired
	private SerieServiceImpl service;
	
//	Para salvar várias series de uma vez o meu requestbody deveria enviar uma lista do tipo serie
	@PostMapping(value="/cadastrar")
	public ResponseEntity<SerieResponseDTO> insert(@RequestBody Serie serie) {
		SerieResponseDTO serieCadastrada = service.create(serie);
        return ResponseEntity.ok(serieCadastrada);
    }

	
	@GetMapping(value="/cadastradas")
	public ResponseEntity<List<SerieResponseDTO>> findAll(){
		return ResponseEntity.ok(service.findAll());
		
	}
	
	@GetMapping(value="/{id}")
	public SerieResponseDTO findById(@PathVariable Long id) {
		SerieResponseDTO serieCadastrada= service.findById(id);
		return serieCadastrada;
	}
	
	@DeleteMapping(value="/deletar/{id}")
	public String deleteById(@PathVariable Long id) {
		return service.deleteById(id);
		
	}
	
	@PutMapping(value="/editar/{id}")
	public ResponseEntity<SerieResponseDTO> update(@PathVariable Long id, @RequestBody Serie editarSerie){
		SerieResponseDTO serieEditada = service.update(id, editarSerie);	
		return ResponseEntity.ok(serieEditada);
	}
	
}
