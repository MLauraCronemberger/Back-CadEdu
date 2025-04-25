package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	//Dessa forma aq o JPA criou uma implementação do select, pq o nosso campo é email tb, aí a gnt n precisa fazer uma query
	Optional<Users> findByEmail(String email);
	

}
