package com.pedro.bookstore.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.pedro.bookstore.domain.Categoria;

public class CategoriaDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	
	@NotEmpty(message = "Nome é obrigatório.")
	@Length(min = 2, max = 100, message = "Nome deve ter entre 3 e 100 caracteres.")
	private String nome;
	
	@NotEmpty(message = "Descrição é obrigatória.")
	@Length(min = 2, max = 255, message = "Descrição deve ter entre 2 e 255 caracteres.")
	private String descricao;
	
	public CategoriaDto() {
		super();
	}
	
	public CategoriaDto(Categoria categoria) {
		super();
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
