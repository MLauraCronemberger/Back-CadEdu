package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.Disciplina;
import com.example.demo.domain.Serie;
import com.example.demo.domain.dto.disciplina.DisciplinaCreateDTO;
import com.example.demo.domain.dto.disciplina.DisciplinaResponseDTO;
import com.example.demo.repository.DisciplinaRepository;
import com.example.demo.repository.SerieRepository;
import com.example.demo.service.DisciplinaService;
import com.example.demo.service.mapper.DisciplinaMapper;

import jakarta.validation.Valid;

@Service
public class DisciplinaServiceImpl implements DisciplinaService{
	
	@Autowired
	private DisciplinaRepository repository;
	
	@Autowired
	private SerieRepository repositorySerie;
	
	private final DisciplinaMapper mapper = DisciplinaMapper.INSTANCE;
	
	@Override
	public DisciplinaResponseDTO create(DisciplinaCreateDTO disciplina) {
		Disciplina newDisciplina = repository.save(mapper.paraEntidade(disciplina));
		return mapper.paraDTO(newDisciplina);
	}
	
	@Override
	public List<DisciplinaResponseDTO> findAll() {
		List<Disciplina> allDisciplinas = repository.findAll();
		return mapper.paraListDTO(allDisciplinas);
	}
	
	@Override
	public DisciplinaResponseDTO findById(@PathVariable Long id) {
		Disciplina disciplina = repository.findById(id).get();
		return mapper.paraDTO(disciplina);
	}
	
	@Override
	public String deleteById(@PathVariable Long id) {
		repository.deleteById(id);
		return "Disciplina Deletada";
	}
	
	@Override
	public DisciplinaResponseDTO update(@PathVariable Long id, @Valid DisciplinaCreateDTO editarDisciplina) {
		Disciplina disciplinaEditada = repository.findById(id).get();
		
		Serie serieDisciplina = repositorySerie.findById(editarDisciplina.getSerie().getId()).orElseThrow(
				() -> new RuntimeException("nao encotrnado...."));
		
		
		disciplinaEditada.setDisc(editarDisciplina.getDisc());
		disciplinaEditada.setCh(editarDisciplina.getCh());
		disciplinaEditada.setSerie(serieDisciplina);
		
		repository.save(disciplinaEditada);
		
		return mapper.paraDTO(disciplinaEditada);
	}
	
	@Override
	public List<DisciplinaResponseDTO> DisciplinasSemDocente(){
		return mapper.paraListDTO(repository.buscarDisciplinasSemDocente());
	}
	
	@Override
	public List<DisciplinaResponseDTO> DisciplinaEditar(@PathVariable Long id){
		Disciplina disc = repository.findById(id).get();
		List<Disciplina> lista = repository.buscarDisciplinasSemDocente();
		lista.add(disc);
		
		return mapper.paraListDTO(lista);
		
	}
	
	@Override
	public List<DisciplinaResponseDTO> Pesquisa(String disc){
		return mapper.paraListDTO(repository.buscarDisciplina(disc));
	}
	

}
