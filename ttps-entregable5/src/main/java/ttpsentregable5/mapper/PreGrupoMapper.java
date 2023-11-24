package ttpsentregable5.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import ttpsentregable5.DTO.PreGrupoDTO;
import ttpsentregable5.model.Grupo;
import ttpsentregable5.model.Categoria;
import ttpsentregable5.model.Usuario;
import ttpsentregable5.repository.CategoriaRepository;
import ttpsentregable5.repository.UsuarioRepository;


@Mapper	
public abstract class PreGrupoMapper {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private UsuarioRepository usuarioReporitory;
	

	
	PreGrupoMapper INSTANCE = Mappers.getMapper(PreGrupoMapper.class);
	
	@Mapping(source = "categoria", target = "categoria" , qualifiedByName = "nomCategoriaACategoria")
	@Mapping(source = "nombreUsuario", target = "usuarios" , qualifiedByName = "agregarUsuario")
    public Grupo DTOtoGrupo(PreGrupoDTO dto) 
	
		
	@Named("nomCategoriaACategoria")
	public static Categoria nomCategoriaACategoria(String nombreCat) {
		return categoriaRepository.recuperarPorNombreCategoria(nombreCat);
	}
	
	@Named("agregarUsuario")
	public static List<Usuario> agregarUsuario(String nombreUsu) {
		Usuario usu = usuarioRepository.recuperarPorNombreUsuario(nombreUsu);
		return Arrays.asList(usu);
	}
	
}
