package br.com.vinciano.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinciano.bookstore.domain.Categoria;
import br.com.vinciano.bookstore.dtos.CategoriaDTO;
import br.com.vinciano.bookstore.repositories.CategoriaRepository;
import br.com.vinciano.bookstore.services.exceptions.DataIntegrityViolationException;
import br.com.vinciano.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer categoriaId) {
		Optional<Categoria> obj = categoriaRepository.findById(categoriaId);
		return obj.orElseThrow( () -> new ObjectNotFoundException("Objecto não encontrato. Id: " + categoriaId + " Tipo: " + Categoria.class.getName() ));		
	}
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}

	public Categoria update(Integer categoriaId, CategoriaDTO objDTO) {
		Categoria obj = findById(categoriaId);
		obj.setNome(objDTO.getNome());
		obj.setDescricao(objDTO.getDescricao());
		return categoriaRepository.save(obj);		
	}

	public void delete(Integer categoriaId) {
		findById(categoriaId);
		try {
			categoriaRepository.deleteById(categoriaId);			
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não da pra apagar a Categoria devido a mesma possuir livros.");
		}
	}
}
