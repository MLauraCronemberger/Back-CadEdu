package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	@Query("SELECT a FROM Aluno a WHERE a.nome ILIKE %:nome%")
	List<Aluno> buscarAluno(@Param("nome") String nome);
		
}
