package br.com.vinciano.bookstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoriaId;
	
	@NotEmpty(message = "O Nome da Categoria é requerido")
	@Length(min = 3, max = 50, message = "O Nome da Categoria deve ter entre 3 e 50 caracteres")
	private String nome;
	
	@NotEmpty(message = "A Descricao da Categoria é requerido")
	@Length(min = 3, max = 50, message = "A Descricao da Categoria deve ter entre 3 e 50 caracteres")
	private String descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoria")
	private List<Livro> livros = new ArrayList<>();
	
	public Categoria() {
		super();
	}

	public Categoria(Integer categoriaId, String nome, String descricao) {
		super();
		this.categoriaId = categoriaId;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getId() {
		return categoriaId;
	}

	public void setId(Integer id) {
		this.categoriaId = id;
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

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoriaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(categoriaId, other.categoriaId);
	}

		
}
