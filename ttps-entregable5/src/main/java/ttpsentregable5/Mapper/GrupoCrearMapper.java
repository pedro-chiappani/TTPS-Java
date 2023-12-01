package ttpsentregable5.Mapper;

import java.util.Arrays;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import ttpsentregable5.DTO.GrupoCrearDTO;
import ttpsentregable5.model.Categoria;
import ttpsentregable5.model.Grupo;
import ttpsentregable5.model.Usuario;
import ttpsentregable5.repository.CategoriaRepository;
import ttpsentregable5.repository.GrupoRepository;
import ttpsentregable5.repository.UsuarioRepository;
import ttpsentregable5.service.CategoriaService;
import ttpsentregable5.service.UsuarioService;


@Mapper
public abstract class GrupoCrearMapper{
	
	@Autowired
	protected CategoriaService categoriaService;
	
	@Autowired
	protected UsuarioService usuarioService;
	
	
	@Mapping(source = "categoria", target = "categoria", qualifiedByName = "nomCategoriaACategoria")
	@Mapping(source = "idUsuario", target = "usuarios", qualifiedByName = "agregarUsuario")
    public abstract Grupo grupoMapper(GrupoCrearDTO dto);
	
	@Named("nomCategoriaACategoria")
	Categoria nomCategoriaACategoria(String nombreCat) throws Exception {
		return categoriaService.obtenerCategoriaDeGrupoPorNombre(nombreCat);
	}
	
	@Named("agregarUsuario")
	List<Usuario> agregarUsuario(Long idUsuario) throws Exception {
		Usuario usu = usuarioService.obtenerPorId(idUsuario);
		return Arrays.asList(usu);
	}
}
