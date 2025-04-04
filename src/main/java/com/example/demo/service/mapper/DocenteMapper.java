package com.example.demo.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.domain.Docente;
import com.example.demo.domain.dto.docente.DocenteCreateDTO;
import com.example.demo.domain.dto.docente.DocenteResponseDTO;

@Mapper(componentModel= "spring")
public interface DocenteMapper {
	DocenteMapper INSTANCE= Mappers.getMapper(DocenteMapper.class);
	
	DocenteResponseDTO paraDTO (Docente docente);
	
	List<DocenteResponseDTO> paraListDTO (List<Docente> docente);
	
	DocenteCreateDTO toDTO (Docente docente);
	
	List<DocenteCreateDTO> toListDTO (List<Docente> docente);
	
	Docente paraEntidade (DocenteCreateDTO docente);
	

}
