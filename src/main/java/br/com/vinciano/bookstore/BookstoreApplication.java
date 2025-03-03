package br.com.vinciano.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.vinciano.bookstore.domain.Categoria;
import br.com.vinciano.bookstore.domain.Livro;
import br.com.vinciano.bookstore.repositories.CategoriaRepository;
import br.com.vinciano.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria c1 = new Categoria(null, "Filosofia", "Livros de Filosofia");
		
		Livro l1 = new Livro(null, "O Mundo de Sofia", "Joster Garder", "texto", c1);
		
		c1.getLivros().add(l1);
		
		categoriaRepository.saveAll(Arrays.asList(c1));
		
		livroRepository.saveAll(Arrays.asList(l1));
		
		
	}

}
