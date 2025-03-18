package br.com.vinciano.bookstore.dtos;

import java.io.Serializable;

import br.com.vinciano.bookstore.domain.Livro;

public class LivroResumidoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer livroID;
	private String titulo;

	public LivroResumidoDTO() {
		super();
	}

	public LivroResumidoDTO(Livro obj) {
		super();
		this.livroID = obj.getLivroId();
		this.titulo = obj.getTitulo();
	}

	public Integer getLivroID() {
		return livroID;
	}

	public void setLivroID(Integer livroID) {
		this.livroID = livroID;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
