package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long>{
	
	@Query(value="SELECT * from Serie a WHERE a.serie = :serie", nativeQuery= true)
	List<Serie> buscarSerie(@Param("serie") int serie);
	

}
