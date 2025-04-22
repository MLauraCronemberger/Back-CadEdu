package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.Aluno;
import com.example.demo.domain.Serie;
import com.example.demo.domain.dto.aluno.AlunoCreateDTO;
import com.example.demo.domain.dto.aluno.AlunoResponseDTO;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.SerieRepository;
import com.example.demo.service.AlunoService;
import com.example.demo.service.mapper.AlunoMapper;

@Service
public class AlunoServiceImpl implements AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	@Autowired
	private SerieRepository repositorySerie;
	
	private final AlunoMapper mapper = AlunoMapper.INSTANCE;
	
	@Override
	public AlunoResponseDTO create(AlunoCreateDTO aluno){
		Aluno newAluno = repository.save(mapper.paraEntidade(aluno));
		return mapper.paraDTO(newAluno);
	}
	
	
	@Override
	public List<AlunoResponseDTO> findAll(){
		List<Aluno> alunos = repository.findAll();
		return mapper.paraListDTO(alunos);
	}

	
	@Override
	public AlunoResponseDTO findById(@PathVariable Long id){
		Aluno aluno = repository.findById(id).get();
		return mapper.paraDTO(aluno);	
	}

	
	@Override
	public String deleteById(@PathVariable Long id){
		repository.deleteById(id);
		return "Aluno Deletado";
	}

	
	@Override
	public AlunoResponseDTO update(@PathVariable Long id, AlunoCreateDTO editarAluno){
		Aluno alunoEditado = repository.findById(id).get();
		Serie serieAluno = repositorySerie.findById(editarAluno.getSerie().getId()).orElseThrow(
				() -> new RuntimeException("nao encotrnado...."));
		
		alunoEditado.setNome(editarAluno.getNome());
		alunoEditado.setCpf(editarAluno.getCpf());
		alunoEditado.setDatnasc(editarAluno.getDatnasc());
		alunoEditado.setResponsavel(editarAluno.getResponsavel());
		alunoEditado.setFoto(editarAluno.getFoto());
		alunoEditado.setserie(serieAluno);
		
		repository.save(alunoEditado);
		
		return mapper.paraDTO(alunoEditado);
	}
	
	
	@Override
	public	List<AlunoResponseDTO> Pesquisa(@PathVariable String nome){
		return mapper.paraListDTO(repository.buscarAluno(nome));
	}

	
	
	

}
