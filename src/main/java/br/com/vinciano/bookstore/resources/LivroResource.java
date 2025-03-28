package br.com.vinciano.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.vinciano.bookstore.domain.Livro;
import br.com.vinciano.bookstore.dtos.LivroDTO;
import br.com.vinciano.bookstore.dtos.LivroResumidoDTO;
import br.com.vinciano.bookstore.services.LivroService;
import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService livroService;

	@GetMapping(value = "/{livroId}")
	public ResponseEntity<Livro> findById(@PathVariable Integer livroId) {
		Livro obj = livroService.findById(livroId);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<LivroResumidoDTO>> findAllPorCategoria(
			@RequestParam(value = "categoria", defaultValue = "0") Integer categoriaId) {
		List<Livro> listLivro = livroService.findAllPorCategoria(categoriaId);
		List<LivroResumidoDTO> listLivroResumidoDTO = listLivro.stream().map(l -> new LivroResumidoDTO(l))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listLivroResumidoDTO);
	}

	@PutMapping(value = "/{livroId}")
	public ResponseEntity<Livro> update(@PathVariable Integer livroId, @Valid @RequestBody Livro obj) {
		Livro objAtualizado = livroService.update(livroId, obj);
		return ResponseEntity.ok().body(objAtualizado);
	}

	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Integer categoriaId,
			@Valid @RequestBody Livro obj) {
		Livro newObj = livroService.create(categoriaId, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{livroId}")
				.buildAndExpand(newObj.getLivroId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{livroId}")
	public ResponseEntity<Void> delete(@PathVariable Integer livroId) {

		livroService.delete(livroId);

		return ResponseEntity.noContent().build();
	}

}
