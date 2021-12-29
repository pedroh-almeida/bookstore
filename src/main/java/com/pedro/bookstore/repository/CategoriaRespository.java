package com.pedro.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedro.bookstore.domain.Categoria;

@Repository
public interface CategoriaRespository extends JpaRepository<Categoria, Integer>{
	
}
