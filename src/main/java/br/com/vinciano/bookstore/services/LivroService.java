package br.com.vinciano.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinciano.bookstore.domain.Categoria;
import br.com.vinciano.bookstore.domain.Livro;
import br.com.vinciano.bookstore.dtos.LivroDTO;
import br.com.vinciano.bookstore.dtos.LivroResumidoDTO;
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
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado. Id: " + livroId + " do tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll() {
		return livroRepository.findAll();
	}

	public List<Livro> findAllPorCategoria(Integer categoriaId) {
		categoriaService.findById(categoriaId);
		return livroRepository.findAllPorCategoria(categoriaId);
	}

	public Livro update(Integer livroID, Livro objAtualizado) {
		Livro obj = findById(livroID);
		UpdateData(obj, objAtualizado);
		return livroRepository.save(obj);
	}

	private void UpdateData(Livro obj, Livro objAtualizado) {
		obj.setNomeAutor(objAtualizado.getNomeAutor());
		obj.setTitulo(objAtualizado.getTitulo());
		obj.setText(objAtualizado.getText());
	}

	public Livro create(Integer categoriaId, Livro obj) {
		Categoria categoria = categoriaService.findById(categoriaId);
		obj.setLivroId(null);
		obj.setCategoria(categoria);
		return livroRepository.save(obj);
	}
	
	public void delete(Integer livroId) {
		Livro obj = findById(livroId);
		livroRepository.delete(obj);
	}

}
