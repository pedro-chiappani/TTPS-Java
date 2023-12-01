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

import ttpsentregable5.DTO.GrupoCrearDTO;
import ttpsentregable5.Mapper.GrupoCrearMapper;
import ttpsentregable5.model.Categoria;
import ttpsentregable5.model.Gasto;
import ttpsentregable5.model.Grupo;
import ttpsentregable5.model.Usuario;
import ttpsentregable5.service.CategoriaService;
import ttpsentregable5.service.GrupoService;

@RestController
@RequestMapping(value = "/grupos", produces = MediaType.APPLICATION_JSON_VALUE)
public class GrupoRestController {

	@Autowired
	private GrupoService grupoService;
	
	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private GrupoCrearMapper grupoMapper;

	@GetMapping("/listarGrupos")
	public ResponseEntity<List<Grupo>> listAllGrupos() {
		List<Grupo> grupos = grupoService.listarGrupos();
		if (grupos.isEmpty()) {
			return new ResponseEntity<List<Grupo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Grupo>>(grupos, HttpStatus.OK);
	}

	@PostMapping("/crearGrupo")
	public ResponseEntity<String> crearGrupo(@RequestBody GrupoCrearDTO grupodto) {
		try {
//			Categoria cat = grupoMapper.nomCategoriaACategoria(grupodto.getCategoria());
//			List<Usuario> usus = grupoMapper.agregarUsuario(grupodto.getNombreUsuario());
//			Grupo grupo = new Grupo();
//			this.grupoService.crear(null);
			if (grupodto.getCategoria()==null
					|| grupodto.getNombre()==null
					|| grupodto.getIdUsuario()==null) {
				return new ResponseEntity<>("Complete todos los campos", HttpStatus.BAD_REQUEST);
			}
			grupoService.validarCamposAltaGrupo(grupodto.getIdUsuario(), grupodto.getNombre(), grupodto.getCategoria());
			
			Grupo grupo = grupoMapper.grupoMapper(grupodto);
			grupoService.guardar(grupo);
			return new ResponseEntity<>("Grupo Creado", HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e);
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
	
	@PutMapping("/{id}")
	public ResponseEntity<String> actualizarGrupo(@PathVariable Long id, @RequestBody Map<String, String> request){
		try {
			String nombre = request.get("nombre");
			String categoria = request.get("categoria");
			
			if (nombre == null && categoria == null) {
				return new ResponseEntity<>("Envie algun dato para actualizar", HttpStatus.BAD_REQUEST);
			}
			
			Grupo grupo = grupoService.obtenerPorId(id);
			
			Categoria nuevaCategoria = categoriaService.obtenerCategoriaDeGrupoPorNombre(categoria);
			
			if (nuevaCategoria == null) {
				return new ResponseEntity<>("Categoria de grupo inexistente", HttpStatus.BAD_REQUEST);
			}else {
				grupo.setCategoria(nuevaCategoria);
			}
			
			if (nombre != null)
				grupo.setNombre(nombre);
			
			grupoService.guardar(grupo);
			
			return new ResponseEntity<>("Grupo Actualizado", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
