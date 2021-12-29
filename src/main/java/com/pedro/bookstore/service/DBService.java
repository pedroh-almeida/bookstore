package com.pedro.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.bookstore.domain.Categoria;
import com.pedro.bookstore.domain.Livro;
import com.pedro.bookstore.repository.CategoriaRespository;
import com.pedro.bookstore.repository.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRespository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDados() {
		Categoria categoria1 = new Categoria(null, "Ficção", "Aventura");
		Categoria categoria2 = new Categoria(null, "Drama", "Sò pra divertir as vezes");
		Categoria categoria3 = new Categoria(null, "Ação", "Violência");

		Livro livro1 = new Livro(null, "The witcher", "Andrzej", "O tempo do machado está chegando", categoria1);
		Livro livro2 = new Livro(null, "Suits", "sei não", "Advogado fodão não fala com cachorrinhos", categoria2);
		Livro livro3 = new Livro(null, "Vikiings", "sei não", "Espada e machado comendo solto Ragnar boladão",
				categoria3);
		Livro livro4 = new Livro(null, "Peak Blinders", "sei não", "Ex guerrilheiro fortalecendo a familia",
				categoria3);

		categoria1.getLivros().addAll(Arrays.asList(livro1));
		categoria2.getLivros().addAll(Arrays.asList(livro2));
		categoria3.getLivros().addAll(Arrays.asList(livro3, livro4));

		this.categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
		this.livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3, livro4));
	}

}
