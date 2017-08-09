package com.ikytus.gip.controller;

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

import com.ikytus.gip.model.Sala;
import com.ikytus.gip.repository.SalaRepository;
import com.ikytus.gip.repository.filter.Filter;
import com.ikytus.gip.service.SalaService;

@Controller
@RequestMapping("/gip/administrador/sala")
public class SalaController {
	
	@Autowired
	private SalaRepository repository;
		
	@Autowired
	private SalaService service;
				
	@GetMapping("/novaSala")
	public ModelAndView novo(Sala sala){
		ModelAndView mv = new ModelAndView("config/cadastroSala");
		mv.addObject(sala);
		return mv;
	}
	
	@PostMapping("/novaSala")
	public ModelAndView salvar(@Valid Sala sala, BindingResult result, RedirectAttributes atributos){
		if(result.hasErrors()){
			return novo(sala);
		}
		service.salvar(sala);
		atributos.addFlashAttribute("mensagem","Sala salva com sucesso!");
		return new ModelAndView("redirect:/gip/administrador/sala/novaSala");
	}
			
	@GetMapping()
	public ModelAndView pesquisa (Filter filtrar){
		ModelAndView mv = new ModelAndView("config/consultaSala");
		mv.addObject("listasala", repository.findAll());
		return mv;
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable Long codigo){
		Sala sala = repository.findOne(codigo); 
		return novo(sala);
	}
	
	@DeleteMapping("/{codigo}")
	public ModelAndView deletar(@PathVariable Long codigo, RedirectAttributes atributos){
		
		repository.delete(codigo);
		
		atributos.addFlashAttribute("mensagem","Sala removida com sucesso!");
		return new ModelAndView("redirect:/gip/administrador/sala");
	}
}