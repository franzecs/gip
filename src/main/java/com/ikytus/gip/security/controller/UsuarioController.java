package com.ikytus.gip.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ikytus.gip.repository.filter.Filter;
import com.ikytus.gip.security.model.Usuario;
import com.ikytus.gip.security.repository.GrupoRepository;
import com.ikytus.gip.security.repository.UsuarioRepository;
import com.ikytus.gip.security.service.UsuarioService;
import com.ikytus.gip.model.Setores;

@Controller
@RequestMapping("/gip/administrador/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	@GetMapping("/novoUsuario")
	public ModelAndView novo(Usuario usuario){
		ModelAndView mv = new ModelAndView("security/cadastroUsuario");
		mv.addObject(usuario);
		mv.addObject("setores", Setores.values());
		mv.addObject("grupos", grupoRepository.findAll());
		return mv;
	}
	
	@PostMapping("/novoUsuario")
	public ModelAndView salvar(@Valid Usuario usuario, BindingResult result, RedirectAttributes atributos){
		if(result.hasErrors()){
			return novo(usuario);
		}
		System.out.println(usuario.getGrupos().toString());
		usuarioService.salvar(usuario);
		atributos.addFlashAttribute("mensagem","Usuário salvo com sucesso!");
		return new ModelAndView("redirect:/gip/administrador/usuario/novoUsuario");
	}
			
	@GetMapping()
	public ModelAndView pesquisa (Filter filtrar){
		ModelAndView mv = new ModelAndView("security/consultaUsuario");
		mv.addObject("listausuarios", usuarioRepository.findAll());
		return mv;
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable Long codigo){
		Usuario usuario = usuarioRepository.findOne(codigo); 
		usuario.setSenha(usuario.getSenha());
		return novo(usuario);
	}
	
	@DeleteMapping("/{codigo}")
	public ModelAndView deletar(@PathVariable Long codigo, RedirectAttributes atributos){
		
		usuarioRepository.delete(codigo);
		
		atributos.addFlashAttribute("mensagem","Usuário removido com sucesso!");
		return new ModelAndView("redirect:/gip/administrador/usuario");
	}
	
}
