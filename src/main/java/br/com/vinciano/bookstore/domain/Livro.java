package br.com.vinciano.bookstore.domain;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer livroId;
	
	@NotEmpty(message = "O Titulo é requerido")
	@Length(min = 3, max = 50, message = "O Titulo deve ter entre 3 e 50 caracteres")
	private String titulo;
	
	@NotEmpty(message = "O Nome do Autor é requerido")
	@Length(min = 3, max = 50, message = "O Nome do Autor deve ter entre 3 e 50 caracteres")
	private String nomeAutor;
	
	@NotEmpty(message = "O Texto do livro é requerido")
	@Length(min = 3, max = 50, message = "O Texto deve ter entre 3 e 200 caracteres")
	private String text;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoriaId")
	private Categoria categoria;
	
	public Livro() {
		super();
	}

	public Livro(Integer livroId, String titulo, String nomeAutor, String text, Categoria categoria) {
		super();
		this.livroId = livroId;
		this.titulo = titulo;
		this.nomeAutor = nomeAutor;
		this.text = text;
		this.categoria = categoria;
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

	@Override
	public int hashCode() {
		return Objects.hash(livroId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(livroId, other.livroId);
	}

}
