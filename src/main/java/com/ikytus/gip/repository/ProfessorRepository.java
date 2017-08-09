package com.ikytus.gip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikytus.gip.model.Professor;


public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	
	public List<Professor>findByNomeContainingIgnoreCase(String nome);
	
	public List<Professor>findByCoordenadorTrueOrderByNome();
	
	public List<Professor>findBySituacaoOrderByNome(String situacao);
}
