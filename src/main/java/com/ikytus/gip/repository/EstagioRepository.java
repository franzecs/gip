package com.ikytus.gip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikytus.gip.model.Aluno;
import com.ikytus.gip.model.Estagio;

public interface EstagioRepository extends JpaRepository<Estagio, Long> {
	
	public List<Estagio>findByAluno(Aluno Aluno);
	
}
