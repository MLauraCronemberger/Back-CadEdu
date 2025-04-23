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

import com.example.demo.domain.dto.serie.SerieCreateDTO;
import com.example.demo.domain.dto.serie.SerieResponseDTO;
import com.example.demo.service.impl.SerieServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/serie")
@CrossOrigin("*")
public class SerieController {
	
	@Autowired
	private SerieServiceImpl service;
	
//	Para salvar várias series de uma vez o meu requestbody deveria enviar uma lista do tipo serie

	@PostMapping(value="/cadastrar")
	public ResponseEntity<SerieResponseDTO> insert(@Valid @RequestBody SerieCreateDTO serie) {
        return ResponseEntity.ok(service.create(serie));
    }

	
	@GetMapping(value="/cadastradas")
	public ResponseEntity<List<SerieResponseDTO>> findAll(){
		return ResponseEntity.ok(service.findAll());
		
	}
	
	@GetMapping(value="/{id}")
	public SerieResponseDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@DeleteMapping(value="/deletar/{id}")
	public String deleteById(@PathVariable Long id) {
		return service.deleteById(id);
		
	}
	
	@PutMapping(value="/editar/{id}")
	public ResponseEntity<SerieResponseDTO> update(@PathVariable Long id, @Valid @RequestBody SerieCreateDTO editarSerie){
		return ResponseEntity.ok(service.update(id, editarSerie));
	}
	
	@GetMapping(value="/pesquisar/{serie}")
	public List<SerieResponseDTO> pesquisa(@PathVariable int serie){
		return service.pesquisa(serie);
	}
}
