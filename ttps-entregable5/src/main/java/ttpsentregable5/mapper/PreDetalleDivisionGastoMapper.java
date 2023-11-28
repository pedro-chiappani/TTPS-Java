package ttpsentregable5.mapper;

import org.mapstruct.Mapper;

import ttpsentregable5.DTO.ElementoDetalleGastoDTO;
import ttpsentregable5.DTO.PreGastoDTO;
import ttpsentregable5.model.DetalleDivisionGasto;
import ttpsentregable5.model.Grupo;

@Mapper
public abstract class PreDetalleDivisionGastoMapper {

	
	
	public abstract DetalleDivisionGasto toDetalleDivisionGasto(ElementoDetalleGastoDTO dto);
	
	
	
	
}
