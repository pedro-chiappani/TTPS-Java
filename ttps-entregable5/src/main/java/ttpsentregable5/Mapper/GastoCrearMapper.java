package ttpsentregable5.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;


import ttpsentregable5.DTO.ElementoDetalleGastoDTO;
import ttpsentregable5.DTO.GastoCrearDTO;
import ttpsentregable5.model.Categoria;
import ttpsentregable5.model.DetalleDivisionGasto;
import ttpsentregable5.model.Gasto;
import ttpsentregable5.model.Grupo;
import ttpsentregable5.model.Usuario;
import ttpsentregable5.repository.CategoriaRepository;
import ttpsentregable5.repository.GrupoRepository;
import ttpsentregable5.repository.UsuarioRepository;

@Mapper
public abstract class GastoCrearMapper {

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
	public abstract Gasto toGasto(GastoCrearDTO dto);
	
	@Named("idGrupoAGrupo")
	Grupo idGrupoAGrupo(long idGrupo) {		
		return grupoRepository.findById(idGrupo).get();
	}
	
	@Named("nomCategoriaACategoria")
	Categoria nomCategoriaACategoria(String nombreCat) {
		return categoriaRepository.recuperarPorNombreCategoriaGasto(nombreCat);
	}
	
	@Named("idCargaGastoAUsuarioCargaGasto")
	Usuario idCargaGastoAUsuarioCargaGasto(long idUsu) {
		return usuarioRepository.findById(idUsu).get();
	}
	
	@Named("idRealizaGastoAUsuarioRealizaGasto")
	Usuario idRealizaGastoAUsuarioRealizaGasto(long idUsu) {
		return usuarioRepository.findById(idUsu).get();
	}
	
	
	@Named("armarDetalleDivisionGasto")
	List<DetalleDivisionGasto> armarDetalleDivisionGasto(List<ElementoDetalleGastoDTO> detalleDivision) {
		List<DetalleDivisionGasto> list = new ArrayList<>();
		return list;
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