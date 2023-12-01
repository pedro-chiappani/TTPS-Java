package ttpsentregable5.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttpsentregable5.DTO.ElementoDetalleGastoDTO;
import ttpsentregable5.DTO.GastoCrearDTO;
import ttpsentregable5.model.DetalleDivisionGasto;
import ttpsentregable5.model.Gasto;
import ttpsentregable5.model.Usuario;
import ttpsentregable5.model.Grupo;
import ttpsentregable5.repository.GastoRepository;
import ttpsentregable5.repository.GrupoRepository;
import ttpsentregable5.repository.UsuarioRepository;

@Service
@Transactional
public class GastoService {

	@Autowired
	private GastoRepository gastoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	public Gasto guardar(Gasto gasto) {
		gastoRepository.save(gasto);		
		return gasto;
	}
	
	
	public Gasto obtenerPorId(Long id) throws Exception {
		Optional<Gasto> gas = gastoRepository.findById(id);
		if (!gas.isPresent()) {
			throw new Exception("No se encontro el gasto");
		}	
		return gas.get();
	}
	
	public void validarCamposAltaGasto(GastoCrearDTO gastoDTO) throws Exception {
		
		//Validar monto distinto de 0
		if(gastoDTO.getMonto().equals(0) ) {
			throw new Exception("El monto no del gasto no puede ser 0");
		}
		
		//Validar grupo existente
		Grupo grupo = grupoRepository.findById(gastoDTO.getIdGrupo()).get(); 
		if( grupo==null ) {
			throw new Exception("El grupo que indican no existe");
		}
		
		
		//Validar carga gasto y realiza gasto usuarios existentes
		if( usuarioRepository.findById(gastoDTO.getCargaGasto())==null || usuarioRepository.findById(gastoDTO.getRealizaGasto())==null) {
			throw new Exception("Usuario que indica inexistente");
		}
		
		//Validar usuarios detalle division gasto sean todos los del id de grupo
		List<Long> idUsuariosGrupo = grupo.getUsuarios().stream().map(Usuario::getId).collect(Collectors.toList());
		List<Long> idUsuariosDetalleGasto = gastoDTO.getDetalleDivisionGasto().stream().map(ElementoDetalleGastoDTO::getIdUsu).collect(Collectors.toList());
		if( !idUsuariosGrupo.containsAll(idUsuariosDetalleGasto) ) {
			throw new Exception("Los usuarios del detalle no pertenecen al grupo que indica");
		}
					
		
	}
	
	public void completarDetalleGasto(Gasto gasto, GastoCrearDTO gastoDTO) throws Exception {
		
		List<DetalleDivisionGasto> ddg;
		for (ElementoDetalleGastoDTO elemDG : gastoDTO.getDetalleDivisionGasto() ) {
			DetalleDivisionGasto dg = new DetalleDivisionGasto(gasto, usuarioRepository.findById(elemDG.getIdUsu()).get(), elemDG.getValor());
			gasto.getDetalleDivisionGasto().add(dg);
		}
					
		
	}
	
	
}