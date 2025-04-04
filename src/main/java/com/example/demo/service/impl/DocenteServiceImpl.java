package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.Docente;
import com.example.demo.domain.dto.docente.DocenteCreateDTO;
import com.example.demo.domain.dto.docente.DocenteResponseDTO;
import com.example.demo.repository.DocenteRepository;
import com.example.demo.service.DocenteService;
import com.example.demo.service.mapper.DocenteMapper;

@Service
public class DocenteServiceImpl implements DocenteService {
	
	@Autowired
	private DocenteRepository repository;
	private final DocenteMapper mapper = DocenteMapper.INSTANCE;
	
	@Override
	public DocenteResponseDTO create(DocenteCreateDTO docente) {
		Docente newDocente = repository.save(mapper.paraEntidade(docente));
		return mapper.paraDTO(newDocente);
	}
	
	@Override
	public List<DocenteResponseDTO> findAll(){
		List<Docente> allDocentes = repository.findAll();
		return mapper.paraListDTO(allDocentes);
	}
	
	@Override
	public DocenteResponseDTO findById(@PathVariable Long id){
		Docente docente =  repository.findById(id).get();
		return mapper.paraDTO(docente);
	}
	
	@Override
	public String deleteById(@PathVariable Long id) {
		repository.deleteById(id);
		return "Docente Deletado";
	}
	
	@Override
	public DocenteResponseDTO update(@PathVariable Long id, Docente editarDocente) {
		Docente docenteEditado = repository.findById(id).get();
		
		docenteEditado.setNome(editarDocente.getNome());
		docenteEditado.setCpf(editarDocente.getCpf());
		docenteEditado.setDatnasc(editarDocente.getDatnasc());
		docenteEditado.setTel(editarDocente.getTel());
		docenteEditado.setEmail(editarDocente.getEmail());
		docenteEditado.setCargo(editarDocente.getCargo());
		docenteEditado.setDisciplina(editarDocente.getDisciplina());
		
		repository.save(docenteEditado);
		
		return mapper.paraDTO(docenteEditado);
	}
	



}
