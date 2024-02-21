package ttpsentregable5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttpsentregable5.model.Categoria;
import ttpsentregable5.repository.CategoriaRepository;

@Service
@Transactional
public class CategoriaService {

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria obtenerCategoriaDeGrupoPorNombre(String nombre) throws Exception{
		Optional<Categoria> cat = categoriaRepository.recuperarPorNombreCategoriaGrupo(nombre);
		if (!cat.isPresent()) {
			throw new Exception("No se encontro la categoria");
		}
		return cat.get();
	}
	
	
	public Categoria obtenerCategoriaDeGastoPorNombre(String nombre) {
		return categoriaRepository.recuperarPorNombreCategoriaGasto(nombre);
	}
	
	public List<Categoria> obtenerCategoriaGasto(){
		
		return categoriaRepository.obtenerCategoriasGasto();
	}
	
	public List<Categoria> obtenerCategoriaGrupo(){
		categoriaRepository.findAll().stream().forEach((cat) -> System.out.println(cat.getNombre()));
		categoriaRepository.obtenerCategoriasGrupo().stream().forEach((c) -> System.out.println(c) );;
		return categoriaRepository.obtenerCategoriasGrupo();
	}
}