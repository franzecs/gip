package com.ikytus.gip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikytus.gip.model.Ies;
import com.ikytus.gip.repository.IesRepository;

@Service
public class IesService {
	
	@Autowired
	private IesRepository repository;
	
	public void salvar(Ies ies){
		ies.setNome(ies.getNome().toUpperCase());
		ies.setSigla(ies.getSigla().toUpperCase());
		ies.setMantenedora(ies.getMantenedora().toUpperCase());
		this.repository.save(ies);
	}
		
	public void salvar(Ies ies, String foto){
		ies.setLogo(foto);
		ies.setNome(ies.getNome().toUpperCase());
		ies.setSigla(ies.getSigla().toUpperCase());
		ies.setMantenedora(ies.getMantenedora().toUpperCase());
		this.repository.save(ies);
	}
	
}
