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
import com.example.demo.domain.Serie;
import com.example.demo.domain.dto.aluno.AlunoResponseDTO;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.service.mapper.AlunoMapper;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@RestController
@RequestMapping(value="/aluno")
@CrossOrigin("*")
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	private final AlunoMapper mapper = AlunoMapper.INTANCE;
	
	@PostMapping(value="/cadastrar")
	public Aluno insert (@RequestBody Aluno aluno) {
		Aluno alunocadastrado = repository.save(aluno);
		return alunocadastrado;
		
	}
	
	@GetMapping(value="/cadastrados")
	public List<AlunoResponseDTO> findAll(){
		List<Aluno> alunos = repository.findAll();
		return mapper.paraListDTO(alunos);
	}
	
	@GetMapping(value="/{id}")
	public AlunoResponseDTO findById(@PathVariable Long id) {
		Aluno aluno = repository.findById(id).get();
		return mapper.paraDTO(aluno);
	}
	
	@DeleteMapping(value="/deletar/{id}")
	public String deleteById(@PathVariable Long id) {
		repository.deleteById(id);
		return "Aluno deletado";
		
	}
	
	@PutMapping(value="/editar/{id}")
	public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno editarAluno){
		Aluno alunoEditado = repository.findById(id).get();
		
		alunoEditado.setNome(editarAluno.getNome());
		alunoEditado.setCpf(editarAluno.getCpf());
		alunoEditado.setDatnasc(editarAluno.getDatnasc());
		alunoEditado.setResponsavel(editarAluno.getResponsavel());
		alunoEditado.setFoto(editarAluno.getFoto());
		alunoEditado.setserie(editarAluno.getserie());
		
		repository.save(alunoEditado);
		
		return ResponseEntity.ok(alunoEditado);
		
	
	}
	

}
