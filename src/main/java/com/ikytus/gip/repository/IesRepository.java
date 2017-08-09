package com.ikytus.gip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikytus.gip.model.Ies;

public interface IesRepository extends JpaRepository<Ies, Long> {
	
	public List<Ies>findByNomeContainingIgnoreCase(String nome);

}
