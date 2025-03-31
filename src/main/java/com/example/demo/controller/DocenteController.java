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
import com.example.demo.domain.dto.docente.DocenteResponseDTO;
import com.example.demo.service.DocenteService;


@RestController
@RequestMapping(value="/docente")
@CrossOrigin("*")
public class DocenteController {
	
	@Autowired
	private DocenteService service;
	
	@PostMapping(value="/cadastrar")
	public DocenteResponseDTO insert(@RequestBody Docente docente) {
		DocenteResponseDTO novodocente = service.create(docente);
		return novodocente;
		
	}
	
	@GetMapping(value="/cadastrados")
	public List<DocenteResponseDTO> findAll(){
		List<DocenteResponseDTO> docentes = service.findAll();
		
		return docentes;
	}
	
	@GetMapping(value="/{id}")
	public DocenteResponseDTO findById(@PathVariable Long id) {
		DocenteResponseDTO docente = service.findById(id);
		return docente;
	}
	
	@DeleteMapping(value="/deletar/{id}")
	public String deleteById(@PathVariable Long id) {
		return service.deleteById(id);
		
	}
	
	@PutMapping(value="/editar/{id}")
	public ResponseEntity<DocenteResponseDTO> update(@PathVariable Long id, @RequestBody Docente editarDocente){
		DocenteResponseDTO docenteEditado = service.update(id, editarDocente);
		return ResponseEntity.ok(docenteEditado);		
		
	}
	
}
		
		
		
		
	
	
	

