package com.ikytus.gip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikytus.gip.model.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {
	
	public List<Sala>findByNomeContainingIgnoreCase(String nome);
	
}
