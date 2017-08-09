package com.ikytus.gip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikytus.gip.model.Professor;
import com.ikytus.gip.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository repository;
	
	public void salvar(Professor professor){
		professor.setNome(professor.getNome().toUpperCase());
		professor.setEndereco(professor.getEndereco().toUpperCase());
		this.repository.save(professor);
	}
}
