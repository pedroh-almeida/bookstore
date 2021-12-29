package com.pedro.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.bookstore.domain.Categoria;
import com.pedro.bookstore.repository.CategoriaRespository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRespository categoriaRepository;
	
	public Categoria findById (Integer id) {
		Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
		return optionalCategoria.orElse(null);
	}
}
