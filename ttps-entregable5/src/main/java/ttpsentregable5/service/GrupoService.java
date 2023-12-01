package ttpsentregable5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttpsentregable5.model.Grupo;
import ttpsentregable5.model.Usuario;
import ttpsentregable5.repository.CategoriaRepository;
import ttpsentregable5.repository.GrupoRepository;
import ttpsentregable5.repository.UsuarioRepository;

@Service
@Transactional
public class GrupoService {

	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
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
	
	public Grupo guardar(Grupo grupo) {
		Usuario usuario = usuarioRepository.recuperarPorNombreUsuario(grupo.getUsuarios().get(0).getNombreUsuario());
		usuario.getGrupos().add(grupo);
		grupoRepository.save(grupo);
		usuarioRepository.save(usuario);
		return grupo;
	}
	
	public void validarCamposAltaGrupo(long idUsuario, String nombre, String categoria) throws Exception {
		Optional<Grupo> gru = grupoRepository.recuperarPorNombre(nombre);
		
		if (gru.isPresent()) {
			throw new Exception("Nombre de grupo existente");
		}
		
		Optional<Usuario> usu = usuarioRepository.findById(idUsuario);
		if (!usu.isPresent()) {
			throw new Exception("No se encontro el usuario");
		}	
		
		if (categoriaRepository.recuperarPorNombreCategoriaGrupo(categoria) == null) {
			throw new Exception("Categoria Inexistente");
		}
					
		
	}
	
	
	
	
}