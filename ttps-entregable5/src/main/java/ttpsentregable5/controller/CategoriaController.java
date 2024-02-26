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

import ttpsentregable5.model.Usuario;
import ttpsentregable5.DTO.LoginDTO;
import ttpsentregable5.model.Categoria;
import ttpsentregable5.model.Grupo;
import ttpsentregable5.repository.CategoriaRepository;
import ttpsentregable5.repository.UsuarioRepository;
import ttpsentregable5.service.TokenServices;
import ttpsentregable5.service.CategoriaService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/categorias", produces= MediaType.APPLICATION_JSON_VALUE)
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/categoriasGrupos")
	public ResponseEntity<List<Categoria>> listCategoriasGrupo(){
		List<Categoria> cats = categoriaService.obtenerCategoriaGrupo();
		return new ResponseEntity<List<Categoria>>(cats, HttpStatus.OK);
	}
	
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/categoriasGastos")
	public ResponseEntity<List<Categoria>> listCategoriasGasto(){
		List<Categoria> cats = categoriaService.obtenerCategoriaGasto();
		return new ResponseEntity<List<Categoria>>(cats, HttpStatus.OK);
	}
}