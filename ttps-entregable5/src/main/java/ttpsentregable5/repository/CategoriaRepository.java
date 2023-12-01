package ttpsentregable5.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ttpsentregable5.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	@Query("SELECT c FROM Categoria c WHERE LOWER(c.nombre)=LOWER(:name) AND tipo=1")
	Optional<Categoria> recuperarPorNombreCategoriaGrupo(@Param("name") String name);
	
	@Query("SELECT c FROM Categoria c WHERE LOWER(c.nombre)=LOWER(:name) AND tipo=2")
	Categoria recuperarPorNombreCategoriaGasto(@Param("name") String name);

}