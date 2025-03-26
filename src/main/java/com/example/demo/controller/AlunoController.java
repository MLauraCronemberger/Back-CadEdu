package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Aluno;
import com.example.demo.repository.AlunoRepository;


@RestController
@RequestMapping(value="/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	
	@PostMapping(value="/cadastrar")
	public Aluno insert (@RequestBody Aluno aluno) {
		Aluno alunocadastrado = repository.save(aluno);
		return alunocadastrado;
		
	}
	
	

		
				
	
}
