package br.com.vinciano.bookstore.dtos;

import java.io.Serializable;

import br.com.vinciano.bookstore.domain.Categoria;
import br.com.vinciano.bookstore.domain.Livro;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer livroId;
	private String titulo;
	private String nomeAutor;
	private String text;

	private Categoria categoria;

	public LivroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LivroDTO(Livro obj) {
		super();
		this.livroId = obj.getLivroId();
		this.titulo = obj.getTitulo();
		this.nomeAutor = obj.getNomeAutor();
		this.text = obj.getText();
		this.categoria = obj.getCategoria();
	}

	public Integer getLivroId() {
		return livroId;
	}

	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
