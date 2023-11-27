package ttpsentregable5.Mapper;

import java.util.Arrays;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import ttpsentregable5.DTO.GrupoCrearDTO;
import ttpsentregable5.model.Categoria;
import ttpsentregable5.model.Grupo;
import ttpsentregable5.model.Usuario;

@Mapper
public abstract class GastoCrearMapper {

	
//	@Mapping(source = "categoria", target = "categoria", qualifiedByName = "nomCategoriaACategoria")
//	@Mapping(source = "nombreUsuario", target = "usuarios", qualifiedByName = "agregarUsuario")
//	public abstract Grupo toGrupo(PreGrupoDTO dto);
//	
//	@Named("nomCategoriaACategoria")
//	Categoria nomCategoriaACategoria(String nombreCat) {
//		return categoriaRepository.recuperarPorNombreCategoriaGrupo(nombreCat);
//	}
//	
//	@Named("agregarUsuario")
//	List<Usuario> agregarUsuario(String nombreUsu) {
//		Usuario usu = usuarioRepository.recuperarPorNombreUsuario(nombreUsu);
//		return Arrays.asList(usu);
//	}
	
	
}
