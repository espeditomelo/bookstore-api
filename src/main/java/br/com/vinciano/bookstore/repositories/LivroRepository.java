package br.com.vinciano.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import br.com.vinciano.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

	@Query ("SELECT obj FROM Livro obj WHERE obj.categoria.categoriaId = :categoriaId ORDER BY obj.titulo")
	List<Livro> findAllPorCategoria(@Param(value = "categoriaId")  Integer categoriaId);

}
