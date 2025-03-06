package br.com.vinciano.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinciano.bookstore.domain.Categoria;
import br.com.vinciano.bookstore.domain.Livro;
import br.com.vinciano.bookstore.repositories.CategoriaRepository;
import br.com.vinciano.bookstore.repositories.LivroRepository;

@Service
public class DBService  {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {

		Categoria c1 = new Categoria(null, "Filosofia", "Livros de Filosofia");
		Categoria c2 = new Categoria(null, "História", "Livros de História");
		
		Livro l1 = new Livro(null, "O Mundo de Sofia", "Joster Garder", "texto", c1);
		Livro l2 = new Livro(null, "História do Brasil", "Machado", "texto", c2);
		
		c1.getLivros().add(l1);
		c2.getLivros().add(l2);
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2));
		
		livroRepository.saveAll(Arrays.asList(l1, l2));
		
	}
}
