package br.com.vinciano.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinciano.bookstore.domain.Categoria;
import br.com.vinciano.bookstore.repositories.CategoriaRepository;
import br.com.vinciano.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer categoriaId) {
		Optional<Categoria> obj = categoriaRepository.findById(categoriaId);
		return obj.orElseThrow( () -> new ObjectNotFoundException("Objecto não encontrato. Id: " + categoriaId + " Tipo: " + Categoria.class.getName() ));		
	}

}
