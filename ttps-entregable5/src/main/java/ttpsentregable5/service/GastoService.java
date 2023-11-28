package ttpsentregable5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttpsentregable5.model.Gasto;
import ttpsentregable5.repository.GastoRepository;

@Service
@Transactional
public class GastoService {

	@Autowired
	private GastoRepository gastoRepository;
	
	
	public Gasto guardar(Gasto gasto) {
		gastoRepository.save(gasto);
		return gasto;
	}
	
	public void validarCamposAltaGasto(String nombreUsuario, String nombre) throws Exception {
		
		//Validar monto distinto de 0
		
		//Validar grupo existente
		
		//Validar carga gasto y realiza gasto usuarios existentes
		
		//Validar usuarios detalle division gasto sean todos los del id de grupo
		
		if(true ) {
			throw new Exception();
		}
					
		
	}
	
}
