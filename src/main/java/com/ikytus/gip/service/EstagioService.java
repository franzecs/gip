package com.ikytus.gip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikytus.gip.model.Aluno;
import com.ikytus.gip.model.Estagio;
import com.ikytus.gip.repository.EstagioRepository;

@Service
public class EstagioService {
	
	@Autowired
	private EstagioRepository repository;
	
	public void salvar(Estagio estagio, Aluno aluno){
		estagio.setAluno(aluno);
		this.repository.save(estagio);
	}
}
