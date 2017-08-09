package com.ikytus.gip.security.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ikytus.gip.security.model.Usuario;
import com.ikytus.gip.security.repository.UsuarioRepository;

@Service
public class UsuarioService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioRepository usuarios;

	
	public void salvar(Usuario usuario){
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		this.usuarios.save(usuario);
	}
}
