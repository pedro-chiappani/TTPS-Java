package ttpsentregable5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttpsentregable5.model.Grupo;
import ttpsentregable5.repository.GrupoRepository;

@Service
@Transactional
public class GrupoService {
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	public Grupo crear(Grupo grupo) {
		return grupoRepository.save(grupo);
	}
	
	public List<Grupo> listarGrupos(){
		return grupoRepository.findAll();
	}
	
	public Grupo obtenerPorId(Long id) throws Exception {
		Optional<Grupo> gru = grupoRepository.findById(id);
		if (!gru.isPresent()) {
			throw new Exception("No se encontro el grupo");
		}	
		return gru.get();
	}

}
