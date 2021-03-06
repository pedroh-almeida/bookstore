package com.pedro.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pedro.bookstore.domain.Categoria;
import com.pedro.bookstore.dto.CategoriaDto;
import com.pedro.bookstore.repository.CategoriaRespository;
import com.pedro.bookstore.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRespository categoriaRepository;

	public Categoria findById(Integer id) {
		Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
		return optionalCategoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrada! Id: " + id + ". Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
	
	public Categoria create(Categoria categoria) {
		categoria.setId(null);
		
		return categoriaRepository.save(categoria);
	}

	public Categoria update(Integer id, CategoriaDto categoriaDto) {
		Categoria categoria = findById(id);
		
		categoria.setNome(categoriaDto.getNome());
		categoria.setDescricao(categoriaDto.getDescricao());
		
		return categoriaRepository.save(categoria);
	}

	public void delete(Integer id) {
		findById(id);
		
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Objeto não pode ser deletada! Existem livros associados.");
		}
	}
}
