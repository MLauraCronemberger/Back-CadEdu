package com.example.demo.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.domain.Serie;
import com.example.demo.domain.dto.serie.SerieCreateDTO;
import com.example.demo.domain.dto.serie.SerieResponseDTO;

@Mapper(componentModel="spring")
public interface SerieMapper {
	SerieMapper INSTANCE = Mappers.getMapper(SerieMapper.class);
	
	SerieResponseDTO paraDTO(Serie serie);
	
	List<SerieResponseDTO> paraListDTO (List<Serie> serie);
	
	SerieCreateDTO toDTO (Serie serie);
	
	Serie paraEntidade (SerieCreateDTO serieCreate);
	
	List<SerieCreateDTO> toListDTO (List<Serie> serie);
	
	
	
	
	
	

}
