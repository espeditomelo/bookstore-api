package br.com.vinciano.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinciano.bookstore.domain.Livro;
import br.com.vinciano.bookstore.repositories.LivroRepository;
import br.com.vinciano.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	CategoriaService categoriaService;
	
	public Livro findById(Integer livroId) {
		Optional<Livro> obj = livroRepository.findById(livroId);
		return obj.orElseThrow( () -> new ObjectNotFoundException("Objeto nao encontrado. Id: " + livroId + " do tipo: " + Livro.class.getName() ));
	}

	public List<Livro> findAll(){
		return livroRepository.findAll();
	}

	public List<Livro> findAllPorCategoria(Integer categoriaId) {
		categoriaService.findById(categoriaId);
		return livroRepository.findAllPorCategoria(categoriaId);
	}
}
