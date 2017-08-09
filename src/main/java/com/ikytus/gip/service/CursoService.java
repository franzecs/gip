package com.ikytus.gip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikytus.gip.model.Curso;
import com.ikytus.gip.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository repository;
	
	public void salvar(Curso curso){
		curso.setNome(curso.getNome().toUpperCase());
		this.repository.save(curso);
	}
}
