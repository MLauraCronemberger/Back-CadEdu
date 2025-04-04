package com.example.demo.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.domain.Disciplina;
import com.example.demo.domain.dto.disciplina.DisciplinaCreateDTO;
import com.example.demo.domain.dto.disciplina.DisciplinaResponseDTO;

@Mapper(componentModel="spring")
public interface DisciplinaMapper {
	DisciplinaMapper INSTANCE= Mappers.getMapper(DisciplinaMapper.class);
	
	DisciplinaResponseDTO paraDTO (Disciplina disciplina);
	
	List<DisciplinaResponseDTO> paraListDTO (List<Disciplina> disciplina);
	
	DisciplinaCreateDTO toDTO (Disciplina disciplina);
	
	List<DisciplinaCreateDTO> toListDTO (List<Disciplina> disciplina);
	
	Disciplina paraEntidade (DisciplinaCreateDTO disciplinaCreate);
	

}
