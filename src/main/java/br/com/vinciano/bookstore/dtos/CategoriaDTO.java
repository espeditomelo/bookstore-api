package br.com.vinciano.bookstore.dtos;

import java.io.Serializable;

import br.com.vinciano.bookstore.domain.Categoria;

public class CategoriaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer categoriaId;
	private String nome;
	private String descricao;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria obj) {
		super();
		this.categoriaId = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
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
