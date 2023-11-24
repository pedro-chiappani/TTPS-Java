package ttpsentregable5.Mapper;

import java.util.Arrays;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import ttpsentregable5.DTO.GrupoCrearDTO;
import ttpsentregable5.model.Categoria;
import ttpsentregable5.model.Grupo;
import ttpsentregable5.model.Usuario;
import ttpsentregable5.repository.CategoriaRepository;
import ttpsentregable5.repository.GrupoRepository;
import ttpsentregable5.repository.UsuarioRepository;

@Mapper	
public abstract class GrupoCrearMapper {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	

	
	GrupoCrearMapper INSTANCE = Mappers.getMapper(GrupoCrearMapper.class);
	
//	@Mapping(source = "categoria", target = "categoria", qualifiedByName = "nomCategoriaACategoria")
//	@Mapping(source = "nombreUsuario", target = "usuarios", qualifiedByName = "agregarUsuario")
//    public Grupo grupoMapper(GrupoCrearDTO dto) {
	
//	@Named("nomCategoriaACategoria")
	public Categoria nomCategoriaACategoria(String nombreCat) {
		return categoriaRepository.recuperarPorNombreCategoria(nombreCat);
	}
//	
//	@Named("agregarUsuario")
	public List<Usuario> agregarUsuario(String nombreUsu) {
		Usuario usu = usuarioRepository.recuperarPorNombreUsuario(nombreUsu);
		return Arrays.asList(usu);
//	}
	}
}
