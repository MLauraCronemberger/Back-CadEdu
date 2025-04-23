package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
//	@Query("SELECT a FROM Aluno a WHERE a.nome ILIKE %:nome%")

//	O ILIKE já faz o tratamento de letra maiuscula e minuscula
//	Mudei para a Query debaixo, que é nativa do PostGre pq quis implementar a pesquisa sem acento, aí pra isso executei "CREATE EXTENSION IF NOT EXISTS unaccent;" no próprio banco
	
	@Query(value= "SELECT * FROM Aluno a WHERE unaccent(a.nome) ILIKE unaccent(CONCAT('%', :nome, '%'))", nativeQuery= true)
	List<Aluno> buscarAluno(@Param("nome") String nome);
		
}
