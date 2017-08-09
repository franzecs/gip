package com.ikytus.gip.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikytus.gip.security.model.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
	
}
