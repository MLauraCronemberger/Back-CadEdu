package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Aluno;
import com.example.demo.repository.AlunoRepository;

@RestController
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	
	@GetMapping("/alunos")
	public List<Aluno> listaTodos() {
		List<Aluno> alunos = repository.findAll();
		return alunos;
	}
	
	@PostMapping("/criar-aluno")
	public Aluno criarAluno(@RequestBody Aluno aluno) {
		System.out.println(aluno.getFoto());
		System.out.println(aluno.getNivelEnsino());
		System.out.println(aluno.getResponsavel());
		
		Aluno alunoSalvo = repository.saveAndFlush(aluno);
		
		return alunoSalvo;
		
				
	}
}
