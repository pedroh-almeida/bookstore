package com.pedro.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.bookstore.domain.Categoria;
import com.pedro.bookstore.domain.Livro;
import com.pedro.bookstore.repository.LivroRepository;
import com.pedro.bookstore.service.exception.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById (Integer id) {
		Optional<Livro> livroOptional = livroRepository.findById(id);
		
		return livroOptional.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! " + id + ", tipo: " + Livro.class.getName()));
	}

	public List<Livro> findByCategoria(Integer idCategoria) {
		categoriaService.findById(idCategoria);
		
		return livroRepository.findByCategoria(idCategoria);
	}

	public Livro update(Integer id, Livro livroBody) {
		Livro livro = findById(id);
		updateData(livro, livroBody);

		return livroRepository.save(livro);
	}

	private void updateData(Livro livro, Livro livroBody) {
		livro.setNome(livroBody.getNome());
		livro.setAutor(livroBody.getAutor());
		livro.setTexto(livroBody.getTexto());
	}

	public Livro create(Integer idCategoria, Livro livroBody) {
		livroBody.setId(null);
		Categoria categoria = categoriaService.findById(idCategoria);
		livroBody.setCategoria(categoria);
		
		return livroRepository.save(livroBody);
	}

	public void delete(Integer id) {
		Livro livro = findById(id);
		
		livroRepository.delete(livro);
	}

}
