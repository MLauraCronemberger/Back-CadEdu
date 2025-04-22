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

import com.example.demo.domain.dto.aluno.AlunoCreateDTO;
import com.example.demo.domain.dto.aluno.AlunoResponseDTO;
import com.example.demo.service.impl.AlunoServiceImpl;

import jakarta.validation.Valid;


@RestController
@RequestMapping(value="/aluno")
@CrossOrigin("*")
public class AlunoController {
	
	@Autowired
	private AlunoServiceImpl service;
	
	@PostMapping(value="/cadastrar")
	public AlunoResponseDTO insert (@Valid @RequestBody AlunoCreateDTO aluno) {
		return service.create(aluno);
		
	}
	
	@GetMapping(value="/cadastrados")
	public List<AlunoResponseDTO> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value="/{id}")
	public AlunoResponseDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@DeleteMapping(value="/deletar/{id}")
	public String deleteById(@PathVariable Long id) {
		return service.deleteById(id);
	}
	
	@PutMapping(value="/editar/{id}")
	public ResponseEntity<AlunoResponseDTO> update(@PathVariable Long id, @Valid @RequestBody AlunoCreateDTO editarAluno){
		return ResponseEntity.ok(service.update(id, editarAluno));
	}
	
	@GetMapping(value="/pesquisar/{nome}")
	public List<AlunoResponseDTO> Pesquisa(@PathVariable String nome){
		return service.Pesquisa(nome);
	}

}
