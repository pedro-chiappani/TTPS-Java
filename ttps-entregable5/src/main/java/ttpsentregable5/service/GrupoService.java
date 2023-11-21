package ttpsentregable5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttpsentregable5.repository.GrupoRepository;

@Service
@Transactional
public class GrupoService {

	@Autowired
	private GrupoRepository grupoRepository;
	
	
	
}
