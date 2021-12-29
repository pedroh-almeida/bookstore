package com.pedro.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedro.bookstore.domain.Categoria;
import com.pedro.bookstore.domain.Livro;
import com.pedro.bookstore.repository.CategoriaRespository;
import com.pedro.bookstore.repository.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRespository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria = new Categoria(null, "ficção", "aventura");
		Livro livro = new Livro(null, "The witcher", "sei lá", "lorem ipsum", categoria);
		
		categoria.getLivros().addAll(Arrays.asList(livro));
		
		this.categoriaRepository.saveAll(Arrays.asList(categoria));
		this.livroRepository.saveAll(Arrays.asList(livro));
	}

}
