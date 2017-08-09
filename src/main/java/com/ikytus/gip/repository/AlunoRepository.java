package com.ikytus.gip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikytus.gip.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	public List<Aluno>findByNomeContainingIgnoreCase(String nome);
	
}
