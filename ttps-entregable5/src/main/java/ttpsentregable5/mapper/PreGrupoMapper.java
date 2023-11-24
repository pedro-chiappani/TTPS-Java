package ttpsentregable5.mapper;

import java.util.Arrays;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import ttpsentregable5.DTO.PreGrupoDTO;
import ttpsentregable5.model.Categoria;
import ttpsentregable5.model.Grupo;
import ttpsentregable5.model.Usuario;
import ttpsentregable5.repository.CategoriaRepository;
import ttpsentregable5.repository.UsuarioRepository;


@Mapper
public abstract class PreGrupoMapper {
	
	@Autowired
	protected CategoriaRepository categoriaRepository;
	
	@Autowired
	protected UsuarioRepository usuarioRepository;
	
	@Mapping(source = "categoria", target = "categoria", qualifiedByName = "nomCategoriaACategoria")
	@Mapping(source = "nombreUsuario", target = "usuarios", qualifiedByName = "agregarUsuario")
	public abstract Grupo toGrupo(PreGrupoDTO dto);
	
	@Named("nomCategoriaACategoria")
	Categoria nomCategoriaACategoria(String nombreCat) {
		return categoriaRepository.recuperarPorNombreCategoria(nombreCat);
	}
	
	@Named("agregarUsuario")
	List<Usuario> agregarUsuario(String nombreUsu) {
		Usuario usu = usuarioRepository.recuperarPorNombreUsuario(nombreUsu);
		return Arrays.asList(usu);
	}
	
}
