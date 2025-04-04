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
import com.example.demo.domain.dto.disciplina.DisciplinaCreateDTO;
import com.example.demo.domain.dto.disciplina.DisciplinaResponseDTO;
import com.example.demo.service.DisciplinaService;

import jakarta.validation.Valid;


@RestController
@RequestMapping(value= "/disciplina")
@CrossOrigin("*")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService service;
	
	
	
	@PostMapping(value= "/cadastrar")
	public DisciplinaResponseDTO insert(@Valid @RequestBody DisciplinaCreateDTO disciplina) {
		return service.create(disciplina);
	}
	
	@GetMapping(value="/cadastradas")
	public List<DisciplinaResponseDTO> findAll(){
		return service.findAll();
	}
	
	
	@GetMapping(value="{id}")
	public DisciplinaResponseDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@DeleteMapping(value="/deletar/{id}")
	public String deleteById(@PathVariable Long id) {
		return service.deleteById(id);
		
	}
	
	@PutMapping(value="/editar/{id}")
	public DisciplinaResponseDTO update(@PathVariable Long id,  @RequestBody Disciplina editarDisciplina){
		return service.update(id, editarDisciplina);
		
	}
	
	@GetMapping(value="/disponiveis")
	public List<DisciplinaResponseDTO> DisciplinasSemDocente(){
		return service.DisciplinasSemDocente();
	}
	
	@GetMapping(value="/dropdown-edit/{id}")
	public List<DisciplinaResponseDTO> DisciplinaEditar(@PathVariable Long id){
		return service.DisciplinaEditar(id);
	}
}
