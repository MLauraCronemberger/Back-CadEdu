package com.example.demo.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.domain.Aluno;
import com.example.demo.domain.dto.aluno.AlunoResponseDTO;



@Mapper(componentModel="spring")
public interface AlunoMapper {
	AlunoMapper INTANCE = Mappers.getMapper(AlunoMapper.class);
	
	AlunoResponseDTO paraDTO (Aluno aluno);
	
	List<AlunoResponseDTO> paraListDTO (List<Aluno> aluno);

	
}
