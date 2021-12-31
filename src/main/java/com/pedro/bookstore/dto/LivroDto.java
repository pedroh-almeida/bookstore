package com.pedro.bookstore.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.pedro.bookstore.domain.Livro;

public class LivroDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	
	@NotEmpty(message = "Nome do livro é obrigatório.")
	@Length(min = 2, max = 100, message = "Nome deve ter entre 3 e 40 caracteres.")
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
