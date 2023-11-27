package ttpsentregable5.controller;

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

import ttpsentregable5.DTO.PreGastoDTO;
import ttpsentregable5.DTO.PreGrupoDTO;
import ttpsentregable5.mapper.PreGastoMapper
import ttpsentregable5.model.Gasto;
import ttpsentregable5.model.Grupo;
import ttpsentregable5.model.Usuario;
import ttpsentregable5.service.GastoService;

@RestController
@RequestMapping(value = "/gastos", produces=MediaType.APPLICATION_JSON_VALUE)
public class GastoRestController {

	@Autowired
	private GastoService gastoService;
	
	@Autowired
	private PreGastoMapper gastoMapper;
	
	//Ejemplo msj: suponiendo que el grupo1 tiene 3 miembros: idusu1,idusu2,idusu5 y idusu8
			//{
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
			//}
	@PostMapping("/cargarGasto")
	public ResponseEntity<String> registrarUsuario(@RequestBody PreGastoDTO gastoDTO) {
			
		try {
			
			//Validar campos completos
			
			
			//Validacion
			gastoService.validarCamposAltaGasto(gastoDTO);
				
			//Mapeo
			Gasto gasto = gastoMapper.toGasto(gastoDTO);
			
		
			this.gastoService.guardar(gasto);
			
			return new ResponseEntity<>("Grupo creado", HttpStatus.CREATED);
			
		} catch ( Exception e ) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	
	}
	
	
	
//	@PutMapping("/id")
//	public ResponseEntity<String> actualizarGasto(@PathVariable Long id, @RequestBody Map<String, String> request) {
//		try {
//			
//			String nombre = request.get("nombre");
//			String categoria = request.get("categoria");
//			
//			if( nombre == null && categoria == null){
//				
//				return new ResponseEntity<>("Envie algun dato para actualizar", HttpStatus.BAD_REQUEST);
//			}
//			
//			 // Verificar si el grupo existe
//			Grupo grupo = grupoService.obtenerPorId(id);
//
//			
//			// Verificar categoria
//			Categoria nuevaCategoria = categoriaService.obtenerCategoriaDeGrupoPorNombre(categoria);
//			if (nuevaCategoria == null) {
//				return new ResponseEntity<>("Categoria de grupo inexistente", HttpStatus.BAD_REQUEST);
//			}else {
//				grupo.setCategoria(nuevaCategoria);				
//			}
//			
//            // Actualizar los campos del grupo
//			if (nombre != null) {
//				grupo.setNombre(nombre);		
//			}
//						           
//            // Guardar el grupo actualizado en la base de datos
//            grupoService.guardar(grupo);
//			
//			return new ResponseEntity<>("Grupo actualzado", HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		}
//
//	}
}



