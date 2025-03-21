package br.com.vinciano.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vinciano.bookstore.domain.Livro;
import br.com.vinciano.bookstore.dtos.LivroDTO;
import br.com.vinciano.bookstore.dtos.LivroResumidoDTO;
import br.com.vinciano.bookstore.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping(value = "/{livroId}")
	public ResponseEntity<Livro> findById(@PathVariable Integer livroId){
		Livro obj = livroService.findById(livroId);
		return ResponseEntity.ok().body(obj);		
	}

//	@GetMapping
//	public ResponseEntity<List<LivroDTO>> findAll(){
//		List<Livro> listLivro = livroService.findAll();
//		List<LivroDTO> listLivroDTO = listLivro.stream().map( obj -> new LivroDTO(obj)).collect(Collectors.toList());
//		return ResponseEntity.ok().body(listLivroDTO);
//	}
	
	@GetMapping
	public ResponseEntity<List<LivroResumidoDTO>> findAllPorCategoria(@RequestParam(value = "categoria", defaultValue = "0") Integer categoriaId){
		List<Livro> listLivro = livroService.findAllPorCategoria (categoriaId); 
		List<LivroResumidoDTO> listLivroResumidoDTO = listLivro.stream().map(l -> new LivroResumidoDTO(l)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listLivroResumidoDTO);
	}
	

}
