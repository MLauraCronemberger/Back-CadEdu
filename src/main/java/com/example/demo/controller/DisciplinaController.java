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

import com.example.demo.domain.Disciplina;
import com.example.demo.repository.DisciplinaRepository;

@RestController
@RequestMapping(value= "/disciplina")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaRepository repository;
	
	@PostMapping(value= "/cadastrar")
	public Disciplina insert(@RequestBody Disciplina disciplina) {
		Disciplina disciplinaCadastrada = repository.save(disciplina);
		return disciplinaCadastrada;
	}
	
	@GetMapping(value="/cadastradas")
	public List<Disciplina> findAll(){
		List<Disciplina> disciplinas = repository.findAll();
		return disciplinas;
	}
	
	@GetMapping(value="{id}")
	public Disciplina findById(@PathVariable Long id) {
		Disciplina disciplinas = repository.findById(id).get();
		return disciplinas;
	}
	
	@DeleteMapping(value="deletar-{id}")
	public String deleteById(@PathVariable Long id) {
		repository.deleteById(id);
		return "Disciplina Deletada";
		
	}
	

}
