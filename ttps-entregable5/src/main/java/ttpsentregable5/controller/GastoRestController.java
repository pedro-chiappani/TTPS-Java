package ttpsentregable5.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttpsentregable5.DTO.ElementoDetalleGastoDTO;
import ttpsentregable5.DTO.GastoCrearDTO;
import ttpsentregable5.DTO.GrupoCrearDTO;
import ttpsentregable5.Mapper.GastoCrearMapper;
import ttpsentregable5.model.Gasto;
import ttpsentregable5.model.Grupo;
import ttpsentregable5.model.Usuario;
import ttpsentregable5.model.Categoria;
import ttpsentregable5.model.DetalleDivisionGasto;
import ttpsentregable5.service.CategoriaService;
import ttpsentregable5.service.GastoService;
import ttpsentregable5.service.UsuarioService;

@RestController
@RequestMapping(value = "/gastos", produces=MediaType.APPLICATION_JSON_VALUE)
public class GastoRestController {

	@Autowired
	private GastoService gastoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@Autowired
	private GastoCrearMapper gastoMapper;
	
	//Ejemplo msj: suponiendo que el grupo1 tiene 3 miembros: idusu1,idusu2,idusu5 y idusu8
//			{
//				"monto": 1000,
//				"imagen": "asdasd",
//				"fecha": "sysdate",
//				"grupo": idgrupo1,
//				"categoria": "nombrecategoria",
//				"cargaGasto" : idusu1,
//				"realizaGasto" : idusu2,
//				"tipoDivisionGasto": 1	
//				"divisiongasto": {									
//						{
//							"usu1": idusu1,
//							"valor": 100
//						},
//						{
//							"usu2": idusu2,
//							"valor": 500
//						},
//						{
//							"usu3": idusu5,
//							"valor": 500
//						},
//						{
//							"usu4": idusu8,
//							"valor": 900
//						}
//					}
//				}
//			}
	@PostMapping("/cargarGasto")
	public ResponseEntity<String> registrarGasto(@RequestBody GastoCrearDTO gastoDTO) {
			
		try {
			
			//Validar campos completos
			if( gastoDTO.getMonto() == null
					|| gastoDTO.getImagen() == null
					|| gastoDTO.getFecha() == null
					|| gastoDTO.getIdGrupo() == null
					|| gastoDTO.getCategoria() == null
					|| gastoDTO.getIdGrupo() == null
					|| gastoDTO.getCargaGasto() == null
					|| gastoDTO.getRealizaGasto() == null
					|| gastoDTO.getTipoDivisionGasto() == null){
				
				return new ResponseEntity<>("Complete todos los campos", HttpStatus.BAD_REQUEST);
			}
			
			//Validacion
			gastoService.validarCamposAltaGasto(gastoDTO);
				
			//Mapeo
			Gasto gasto = gastoMapper.toGasto(gastoDTO);
			gastoService.completarDetalleGasto(gasto, gastoDTO);
			
			this.gastoService.guardar(gasto);
			
			return new ResponseEntity<>("Gasto creado", HttpStatus.CREATED);
			
		} catch ( Exception e ) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	
	}
	
	
	//Solo se acutuializan datos no relevantes, por ej si se quiere cambiar la distribucion del gasto se hace por otro endpoint
	//por lo tanto el monto no se puede cambiar, se relaciona directamente con esto
	
	//Cambiar el grupo no existe, tema monto y distribucion otro endpoint
	@PutMapping("/{id}")
	public ResponseEntity<String> actualizarGasto(@PathVariable Long id, @RequestBody Map<String, Object> request) {
		try {
			
			String imagen = (String)request.get("imagen");
			String categoria = (String)request.get("categoria");
			Long idUsuCarga = Long.parseLong(request.get("cargaGasto").toString());
			Long idUsuRealiza = Long.parseLong(request.get("realizaGasto").toString()); 
			
			if( imagen == null || categoria == null || idUsuCarga==null || idUsuRealiza==null){
				
				return new ResponseEntity<>("Envie algun dato para actualizar", HttpStatus.BAD_REQUEST);
			}
			
			// Verificar si el grupo existe
			Gasto gasto = gastoService.obtenerPorId(id);
			
			// Verificar si los usuarios existen y pertenecen al grupo del gasto
			Usuario nuevoCargaGasto = usuarioService.obtenerPorId(idUsuCarga);
			if (nuevoCargaGasto == null) {
				return new ResponseEntity<>("Usuario de carga de gasto inexistente", HttpStatus.BAD_REQUEST);
			}else {
				gasto.setCargaGasto(nuevoCargaGasto);			
			}
			
			Usuario nuevoRealizaGasto = usuarioService.obtenerPorId(idUsuRealiza);
			if (nuevoRealizaGasto == null) {
				return new ResponseEntity<>("Usuario de realiza de gasto inexistente", HttpStatus.BAD_REQUEST);
			}else {
				gasto.setRealizaGasto(nuevoRealizaGasto);			
			}
			
			
			// Verificar categoria
			Categoria nuevaCategoria = categoriaService.obtenerCategoriaDeGastoPorNombre(categoria);
			if (nuevaCategoria == null) {
				return new ResponseEntity<>("Categoria de gasto inexistente", HttpStatus.BAD_REQUEST);
			}else {
				gasto.setCategoria(nuevaCategoria);				
			}
			
            // Actualizar los campos faltantes
			gasto.setImagen(imagen);
						           
            // Guardar el grupo actualizado en la base de datos
            gastoService.guardar(gasto);
			
			return new ResponseEntity<>("Gasto actualzado", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
}