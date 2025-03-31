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

import com.example.demo.domain.Aluno;
import com.example.demo.domain.dto.aluno.AlunoResponseDTO;
import com.example.demo.service.impl.AlunoServiceImpl;


@RestController
@RequestMapping(value="/aluno")
@CrossOrigin("*")
public class AlunoController {
	
	@Autowired
	private AlunoServiceImpl service;
	
	@PostMapping(value="/cadastrar")
	public AlunoResponseDTO insert (@RequestBody Aluno aluno) {
		AlunoResponseDTO alunocadastrado = service.create(aluno);
		return alunocadastrado;
		
	}
	
	@GetMapping(value="/cadastrados")
	public List<AlunoResponseDTO> findAll(){
		List<AlunoResponseDTO> alunos = service.findAll();
		return alunos;
	}
	
	@GetMapping(value="/{id}")
	public AlunoResponseDTO findById(@PathVariable Long id) {
		AlunoResponseDTO aluno = service.findById(id);
		return aluno;
	}
	
	@DeleteMapping(value="/deletar/{id}")
	public String deleteById(@PathVariable Long id) {
		return service.deleteById(id);
	}
	
	@PutMapping(value="/editar/{id}")
	public ResponseEntity<AlunoResponseDTO> update(@PathVariable Long id, @RequestBody Aluno editarAluno){
		AlunoResponseDTO alunoEditado = service.update(id, editarAluno);

		return ResponseEntity.ok(alunoEditado);
	}
	

}
