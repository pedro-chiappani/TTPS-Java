package ttpsentregable5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ttpsentregable5.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("SELECT u FROM Usuario u WHERE LOWER(u.nombreUsuario)=LOWER(:name)")
	Usuario recuperarPorNombreUsuario(@Param("name") String name);
	
	@Query("SELECT u FROM Usuario u WHERE LOWER(u.email)=LOWER(:email)")
	Usuario recuperarPorEmail(@Param("email") String email);
}