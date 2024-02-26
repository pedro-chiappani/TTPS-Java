package ttpsentregable5.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ttpsentregable5.model.Grupo;
import ttpsentregable5.model.Usuario;

public interface GrupoRepository extends JpaRepository<Grupo, Long>{

	@Query("SELECT g FROM Grupo g WHERE LOWER(g.nombre)=LOWER(:name)")
	Optional<Grupo> recuperarPorNombre(@Param("name") String name);
	
	@Query("SELECT g.usuarios FROM Grupo g WHERE g.id=(:id)")
	List<Usuario> obtenerUsuariosGrupo(@Param("id") Long id);
	
}
