package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Disciplina;
import com.example.demo.domain.dto.disciplina.DisciplinaResponseDTO;
import com.example.demo.service.DisciplinaService;


@RestController
@RequestMapping(value= "/disciplina")
@CrossOrigin("*")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService service;
	
	@PostMapping(value= "/cadastrar")
	public DisciplinaResponseDTO insert(@RequestBody Disciplina disciplina) {
		DisciplinaResponseDTO disciplinaCadastrada = service.create(disciplina);
		return disciplinaCadastrada;
	}
	
	@GetMapping(value="/cadastradas")
	public List<DisciplinaResponseDTO> findAll(){
		List<DisciplinaResponseDTO> disciplinas = service.findAll();
		return disciplinas;
	}
	
	
	@GetMapping(value="{id}")
	public DisciplinaResponseDTO findById(@PathVariable Long id) {
		DisciplinaResponseDTO disciplinas = service.findById(id);
		return disciplinas;
	}
	
	@DeleteMapping(value="/deletar/{id}")
	public String deleteById(@PathVariable Long id) {
		return service.deleteById(id);
		
	}
	
	@PutMapping(value="/editar/{id}")
	public DisciplinaResponseDTO update(@PathVariable Long id, @RequestBody Disciplina editarDisciplina){
		DisciplinaResponseDTO disciplinaEditada = service.update(id, editarDisciplina);
		return disciplinaEditada;
		
	}
}
