package com.ikytus.gip.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikytus.gip.security.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Usuario findByFuncional(String funcional);


}
