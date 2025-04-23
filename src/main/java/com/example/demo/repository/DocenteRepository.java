package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {
	
	@Query(value="SELECT * FROM Docente a WHERE unaccent(a.nome) ILIKE unaccent(CONCAT('%', :nome, '%'))", nativeQuery= true)
	List<Docente> buscarDocente(@Param ("nome") String nome);

}
