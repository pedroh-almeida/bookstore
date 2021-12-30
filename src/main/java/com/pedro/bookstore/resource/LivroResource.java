package com.pedro.bookstore.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.bookstore.domain.Livro;
import com.pedro.bookstore.dto.LivroDto;
import com.pedro.bookstore.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	
	@Autowired
	private LivroService livroService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById (@PathVariable Integer id) {
		Livro livro = livroService.findById(id);
		
		return ResponseEntity.ok().body(livro);
	}
	
	@GetMapping
	public ResponseEntity<List<LivroDto>> findByCategoria (@RequestParam(value = "categoria", defaultValue = "0") Integer idCategoria) {
		List<Livro> livros = livroService.findByCategoria(idCategoria);
		
		List<LivroDto> livrosDto = livros.stream().map(obj -> new LivroDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(livrosDto);
		// localhost:8080/livros?categoria=1
	}

}
