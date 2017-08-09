package com.ikytus.gip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikytus.gip.model.Curso;
import com.ikytus.gip.model.Ies;


public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	public List<Curso>findByNomeContainingIgnoreCase(String nome);
	
	public List<Curso>findByIes(Ies ies);

}
