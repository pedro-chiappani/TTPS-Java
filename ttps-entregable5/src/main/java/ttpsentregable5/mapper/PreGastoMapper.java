package ttpsentregable5.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import ttpsentregable5.DTO.ElementoDetalleGastoDTO;
import ttpsentregable5.DTO.PreGastoDTO;
import ttpsentregable5.DTO.PreGrupoDTO;
import ttpsentregable5.model.Categoria;
import ttpsentregable5.model.DetalleDivisionGasto;
import ttpsentregable5.model.Gasto;
import ttpsentregable5.model.Grupo;
import ttpsentregable5.model.Usuario;
import ttpsentregable5.repository.CategoriaRepository;
import ttpsentregable5.repository.GrupoRepository;
import ttpsentregable5.repository.UsuarioRepository;

@Mapper
public abstract class PreGastoMapper {

	@Autowired
	protected GrupoRepository grupoRepository;
	
	@Autowired
	protected CategoriaRepository categoriaRepository;
	
	@Autowired
	protected UsuarioRepository usuarioRepository;
	
	@Mapping(source = "idGrupo", target = "grupo", qualifiedByName ="idGrupoAGrupo")
	@Mapping(source = "categoria", target = "categoria", qualifiedByName = "nomCategoriaACategoria")
	@Mapping(source = "cargaGasto", target = "cargaGasto", qualifiedByName = "idCargaGastoAUsuarioCargaGasto")
	@Mapping(source = "realizaGasto", target = "realizaGasto", qualifiedByName = "idRealizaGastoAUsuarioRealizaGasto")
	@Mapping(source = "detalleDivisionGasto", target = "detalleDivisionGasto", qualifiedByName = "armarDetalleDivisionGasto")
	public abstract Gasto toGasto(PreGastoDTO dto);
	
	@Named("nomCategoriaACategoria")
	Categoria nomCategoriaACategoria(String nombreCat) {
		return categoriaRepository.recuperarPorNombreCategoriaGasto(nombreCat);
	}
	
	@Named("idGrupoAGrupo")
	Grupo idGrupoAGrupo(Long idGrupo) {		
		return grupoRepository.findById(idGrupo).get();
	}
	
	@Named("idCargaGastoAUsuarioCargaGasto")
	Usuario idCargaGastoAUsuarioCargaGasto(Long idUsu) {
		return usuarioRepository.findById(idUsu).get();
	}
	
	@Named("idRealizaGastoAUsuarioRealizaGasto")
	Usuario idRealizaGastoAUsuarioRealizaGasto(Long idUsu) {
		return usuarioRepository.findById(idUsu).get();
	}
	
	
	@Named("armarDetalleDivisionGasto")
	List<DetalleDivisionGasto> armarDetalleDivisionGasto(List<ElementoDetalleGastoDTO> detalleDivision) {
		List<DetalleDivisionGasto> list = new ArrayList<>();
		return list; //el detalle se realiza en otro mapper, se inicializa la lista en null
	}
	
	
//	"divisiongasto": {									
//		{
//			"usu1": idusu1,
//			"valor": 100
//		},
//		{
//			"usu2": idusu2,
//			"valor": 500
//		},
//		{
//			"usu3": idusu5,
//			"valor": 500
//		},
//		{
//			"usu4": idusu8,
//			"valor": 900
//		}
//	}
	
}
