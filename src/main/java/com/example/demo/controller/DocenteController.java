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

import com.example.demo.domain.Disciplina;
import com.example.demo.domain.Docente;
import com.example.demo.domain.dto.docente.DocenteResponseDTO;
import com.example.demo.repository.DocenteRepository;
import com.example.demo.service.mapper.DocenteMapper;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@RestController
@RequestMapping(value="/docente")
@CrossOrigin("*")
public class DocenteController {
	
	@Autowired
	private DocenteRepository repository;
	private final DocenteMapper mapper = DocenteMapper.INSTANCE;
	
	@PostMapping(value="/cadastrar")
	public Docente insert(@RequestBody Docente docente) {
		Docente novodocente = repository.save(docente);
		return novodocente;
		
	}
	
	@GetMapping(value="/cadastrados")
	public List<DocenteResponseDTO> findAll(){
		List<Docente> docentes = repository.findAll();
		
		return mapper.paraListDTO(docentes);
	}
	
	@GetMapping(value="/{id}")
	public DocenteResponseDTO findById(@PathVariable Long id) {
		Docente docente = repository.findById(id).get();
		return mapper.paraDTO(docente);
	}
	
	@DeleteMapping(value="/deletar/{id}")
	public String deleteById(@PathVariable Long id) {
		repository.deleteById(id);
		return "Docente deletado";
		
	}
	
	@PutMapping(value="/editar/{id}")
	public ResponseEntity<Docente> update(@PathVariable Long id, @RequestBody Docente editarDocente){
		Docente docenteEditado = repository.findById(id).get();
		
		docenteEditado.setNome(editarDocente.getNome());
		docenteEditado.setCpf(editarDocente.getCpf());
		docenteEditado.setDatnasc(editarDocente.getDatnasc());
		docenteEditado.setTel(editarDocente.getTel());
		docenteEditado.setEmail(editarDocente.getEmail());
		docenteEditado.setCargo(editarDocente.getCargo());
		docenteEditado.setDisciplina(editarDocente.getDisciplina());
		
		repository.save(docenteEditado);
		
		return ResponseEntity.ok(docenteEditado);		
		
	}
	
}
		
		
		
		
	
	
	

