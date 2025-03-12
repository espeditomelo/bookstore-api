package br.com.vinciano.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.vinciano.bookstore.domain.Categoria;
import br.com.vinciano.bookstore.dtos.CategoriaDTO;
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
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> list = categoriaService.findAll();
		List<CategoriaDTO> listDTO = list.stream().map( obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public  ResponseEntity<Categoria> create(@RequestBody Categoria obj){
		obj = categoriaService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{categoriaId}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Integer categoriaId, @RequestBody CategoriaDTO objDTO){
		Categoria obj = categoriaService.update(categoriaId, objDTO);
		return ResponseEntity.ok().body(new CategoriaDTO(obj));
	}
	
	@DeleteMapping(value = "/{categoriaId}")
	public ResponseEntity<Void> delete(@PathVariable Integer categoriaId){
		categoriaService.delete(categoriaId);
		return ResponseEntity.noContent().build();
	}

}
