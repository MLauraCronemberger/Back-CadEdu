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

import com.example.demo.domain.Docente;
import com.example.demo.domain.dto.docente.DocenteCreateDTO;
import com.example.demo.domain.dto.docente.DocenteResponseDTO;
import com.example.demo.service.DocenteService;

import jakarta.validation.Valid;


@RestController
@RequestMapping(value="/docente")
@CrossOrigin("*")
public class DocenteController {
	
	@Autowired
	private DocenteService service;
	
	@PostMapping(value="/cadastrar")
	public DocenteResponseDTO insert(@Valid @RequestBody DocenteCreateDTO docente) {
		return service.create(docente);
	}
	
	@GetMapping(value="/cadastrados")
	public List<DocenteResponseDTO> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value="/{id}")
	public DocenteResponseDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@DeleteMapping(value="/deletar/{id}")
	public String deleteById(@PathVariable Long id) {
		return service.deleteById(id);
	}
	
	@PutMapping(value="/editar/{id}")
	public ResponseEntity<DocenteResponseDTO> update(@PathVariable Long id, @RequestBody Docente editarDocente){
		return ResponseEntity.ok(service.update(id, editarDocente));		
	}
	
}
		
		
		
		
	
	
	

