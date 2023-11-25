package ttpsentregable5.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttpsentregable5.DTO.PreGrupoDTO;
import ttpsentregable5.mapper.PreGrupoMapper;
import ttpsentregable5.model.Gasto;
import ttpsentregable5.model.Grupo;
import ttpsentregable5.model.Usuario;
import ttpsentregable5.service.GrupoService;

@RestController
@RequestMapping(value = "/grupos", produces=MediaType.APPLICATION_JSON_VALUE)
public class GrupoRestController {

	
	@Autowired
	private GrupoService grupoService;

	@Autowired
	private PreGrupoMapper grupoMapper;
	
	
	@GetMapping("/listarGrupos")
	public ResponseEntity<List<Grupo>> listarGrupos() {
		List<Grupo> grupos = grupoService.listarGrupos();
		
		
		
		if(grupos.isEmpty()){
			return new ResponseEntity<List<Grupo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Grupo>>(grupos, HttpStatus.OK);
	}
	
	@PostMapping("/crearGrupo")
	public ResponseEntity<String> crearGrupo(@RequestBody PreGrupoDTO grupoDTO) {
			
		try {
			
			//Validar campos completos
			if( grupoDTO.getCategoria() == null
					|| grupoDTO.getNombre() == null
					|| grupoDTO.getNombreUsuario() == null){
				
				return new ResponseEntity<>("Complete todos los campos", HttpStatus.BAD_REQUEST);
			}
			
			//Validacion
			grupoService.validarCamposAltaGrupo(grupoDTO.getNombreUsuario(), grupoDTO.getNombre());
				
			//Mapeo
			Grupo grupo = grupoMapper.toGrupo(grupoDTO);
			
//			System.out.println("Grupo: " + grupo.toString());
//			System.out.println("usuariosgrupo: " + grupo.getUsuarios().size() + "//" + grupo.getUsuarios().get(0).toString());
			
			this.grupoService.crear(grupo);
			
			return new ResponseEntity<>("Grupo creado", HttpStatus.CREATED);
			
		} catch ( Exception e ) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	   
	}
	
	
	@GetMapping("/{id}/gastos")
	public ResponseEntity<List<Gasto>> listarGastos(@PathVariable("id") Long id) {
		try {
			Grupo gru = grupoService.obtenerPorId(id);
			if (gru.getGastos().isEmpty())
				return new ResponseEntity<List<Gasto>>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<List<Gasto>>(gru.getGastos(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<List<Gasto>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PutMapping("/id")
	public ResponseEntity<String> actualizarGrupo() {

		try {
			return new ResponseEntity<>("Grupo actualzado", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	
	
	
	
}
