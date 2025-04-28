package com.example.demo.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.domain.Users;
import com.example.demo.domain.dto.users.UsersCreateDTO;
import com.example.demo.domain.dto.users.UsersResponseDTO;

@Mapper(componentModel="spring")
public interface UsersMapper {
	
	UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);
	
	UsersCreateDTO paraCreateDTO (Users user);
	
	UsersResponseDTO paraResponseDTO (Users user);
	
	Users paraLoginDTO (UsersResponseDTO user);
	
	
	

}
