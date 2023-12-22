package ttpsentregable5.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttpsentregable5.DTO.PreGrupoDTO;
import ttpsentregable5.DTO.UpdtGrupoDTO;
import ttpsentregable5.mapper.PreGrupoMapper;
import ttpsentregable5.model.Categoria;
import ttpsentregable5.model.Gasto;
import ttpsentregable5.model.Grupo;
import ttpsentregable5.model.Usuario;
import ttpsentregable5.service.CategoriaService;
import ttpsentregable5.service.GrupoService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/grupos", produces=MediaType.APPLICATION_JSON_VALUE)
public class GrupoRestController {

	
	@Autowired
	private GrupoService grupoService;

	@Autowired
	private CategoriaService categoriaService;
	
	
	@Autowired
	private PreGrupoMapper grupoMapper;
	
	@CrossOrigin("http://localhost:4200/") 
	@GetMapping("/listarGrupos")
	public ResponseEntity<List<Grupo>> listarGrupos() {
		List<Grupo> grupos = grupoService.listarGrupos();
		
		
		
		if(grupos.isEmpty()){
			return new ResponseEntity<List<Grupo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Grupo>>(grupos, HttpStatus.OK);
	}
	
	
//	{
//	  "idUsuario":"1",
//	  "categoria":"nombreCategoria",
//	  "nombre":"nombreGrupo"
//	}
	@CrossOrigin("http://localhost:4200/") 
	@PostMapping("/crearGrupo")
	public ResponseEntity<String> crearGrupo(@RequestBody PreGrupoDTO grupoDTO) {
		System.out.println(grupoDTO.getCategoria());
		System.out.println(grupoDTO.getNombre());
		System.out.println(grupoDTO.getIdUsuario());
		try {
			
			//Validar campos completos
			if( grupoDTO.getCategoria() == null
					|| grupoDTO.getNombre() == null
					|| grupoDTO.getIdUsuario() == null){
				
				return new ResponseEntity<>("Complete todos los campos", HttpStatus.BAD_REQUEST);
			}
			
			//Validacion
			grupoService.validarCamposAltaGrupo(grupoDTO.getIdUsuario(), grupoDTO.getNombre(), grupoDTO.getCategoria());
			
			//Mapeo
			Grupo grupo = grupoMapper.toGrupo(grupoDTO);
			
			this.grupoService.guardar(grupo);
			
			return new ResponseEntity<>("Grupo creado", HttpStatus.CREATED);
			
		} catch ( Exception e ) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	   
	}
	
	@CrossOrigin("http://localhost:4200/") 
	@GetMapping("/{id}/gastos")
	public ResponseEntity<List<Gasto>> listarGastos(@PathVariable("id") Long id) {
		try {
			Grupo gru = grupoService.obtenerPorId(id);
			if (gru.getGastos().isEmpty())
				return new ResponseEntity<List<Gasto>>(HttpStatus.NO_CONTENT);
			
			System.out.println(gru.getGastos().size());
			
			return new ResponseEntity<List<Gasto>>(gru.getGastos(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<List<Gasto>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin("http://localhost:4200/") 
	@PutMapping("/{id}")
	public ResponseEntity<String> actualizarGrupo(@PathVariable Long id, @RequestBody UpdtGrupoDTO grupoDTO) {
		try {
			
			
			if( grupoDTO.getNombre() == null && grupoDTO.getCategoria() == null){
				
				return new ResponseEntity<>("Envie algun dato para actualizar", HttpStatus.BAD_REQUEST);
			}
			
			// Verificar si el grupo existe
			Grupo grupo = grupoService.obtenerPorId(id);

			
			// Verificar categoria
			Categoria nuevaCategoria = categoriaService.obtenerCategoriaDeGrupoPorNombre(grupoDTO.getCategoria());
			if (nuevaCategoria == null) {
				return new ResponseEntity<>("Categoria de grupo inexistente", HttpStatus.BAD_REQUEST);
			}else {
				grupo.setCategoria(nuevaCategoria);				
			}
			
            grupo.setNombre(grupoDTO.getNombre());		
									           
            // Guardar el grupo actualizado en la base de datos
            grupoService.guardar(grupo);
			
			return new ResponseEntity<>("Grupo actualzado", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	
	
	
	
}
