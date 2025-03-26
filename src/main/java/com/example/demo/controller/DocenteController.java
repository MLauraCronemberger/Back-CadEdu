package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Docente;
import com.example.demo.repository.DocenteRepository;

@RestController
@RequestMapping(value="/docente")
public class DocenteController {
	
	@Autowired
	private DocenteRepository repository;
	
	@PostMapping(value="/cadastrar")
	public Docente insert(@RequestBody Docente docente) {
		Docente novodocente = repository.save(docente);
		return novodocente;
		
	}
	
	@GetMapping(value="/cadastrados")
	public List<Docente> findAll(){
		List<Docente> docentes = repository.findAll();
		return docentes;
	}
	
	@GetMapping(value="/{id}")
	public Docente findById(@PathVariable Long id) {
		Docente docente = repository.findById(id).get();
		return docente;
	}
	
	@DeleteMapping(value="/deletar-{id}")
	public String deleteById(@PathVariable Long id) {
		repository.deleteById(id);
		return "Docente deletado";
		
	}

}
