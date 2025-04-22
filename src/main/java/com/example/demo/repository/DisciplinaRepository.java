package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
	
	@Query("SELECT d FROM Disciplina d WHERE NOT EXISTS (SELECT 1 FROM Docente doc WHERE doc.disciplina = d)")
    List<Disciplina> buscarDisciplinasSemDocente();
	
	//Usando a Query nativa do banco de dados, aí tem q ser tudo como está no banco
//	@Query(value= "SELECT a FROM disciplina a WHERE a.nome like ?1", nativeQuery = true)
//	@Query(value= "SELECT a FROM Disciplina a WHERE a.nome LIKE CONCAT('%', ?1, '%')\", nativeQuery = true)

	//Usando o JPQL, aí tudo tem que estar de acordo com as Entidades
	@Query("SELECT a FROM Disciplina a WHERE a.disc ILIKE %:disc%")
	List<Disciplina> buscarDisciplina(@Param("disc") String disc);
	
}
