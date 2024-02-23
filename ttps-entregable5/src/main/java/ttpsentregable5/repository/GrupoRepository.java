package ttpsentregable5.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ttpsentregable5.model.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Long>{

	@Query("SELECT g FROM Grupo g WHERE LOWER(g.nombre)=LOWER(:name)")
	Optional<Grupo> recuperarPorNombre(@Param("name") String name);
	
	@Query("SELECT g FROM Grupo g JOIN g.usuarios u WHERE u.id = :usuId")
    List<Grupo> recuperarGruposPorUsuarioId(@Param("usuId") Long usuId);
	
}
