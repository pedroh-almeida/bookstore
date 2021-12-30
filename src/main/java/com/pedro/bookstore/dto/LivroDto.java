package com.pedro.bookstore.dto;

import java.io.Serializable;

import com.pedro.bookstore.domain.Livro;

public class LivroDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	
	public LivroDto() {
		super();
	}

	public LivroDto(Livro livro) {
		super();
		this.id = livro.getId();
		this.nome = livro.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
