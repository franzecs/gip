package com.ikytus.gip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikytus.gip.model.Sala;
import com.ikytus.gip.repository.SalaRepository;

@Service
public class SalaService {
	
	@Autowired
	private SalaRepository repository;
	
	public void salvar(Sala sala){
		this.repository.save(sala);
	}
}
