package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
	
	@Query("SELECT d FROM Disciplina d WHERE NOT EXISTS (SELECT 1 FROM Docente doc WHERE doc.disciplina = d)")
    List<Disciplina> buscarDisciplinasSemDocente();

}
