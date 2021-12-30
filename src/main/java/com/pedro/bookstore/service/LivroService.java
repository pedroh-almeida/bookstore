package com.pedro.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.bookstore.domain.Livro;
import com.pedro.bookstore.repository.LivroRepository;
import com.pedro.bookstore.service.exception.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	public Livro findById (Integer id) {
		Optional<Livro> livroOptional = livroRepository.findById(id);
		
		return livroOptional.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! " + id + ", tipo: " + Livro.class.getName()));
	}
}
