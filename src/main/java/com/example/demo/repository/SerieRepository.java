package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long>{

}
