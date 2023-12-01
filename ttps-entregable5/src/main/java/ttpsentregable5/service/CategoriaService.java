package ttpsentregable5.service;

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
}