package br.com.vinciano.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vinciano.bookstore.domain.Categoria;
import br.com.vinciano.bookstore.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(value = "/{categoriaId}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer categoriaId){
		Categoria obj = categoriaService.findById(categoriaId);
		return ResponseEntity.ok().body(obj);
	}
	

}
