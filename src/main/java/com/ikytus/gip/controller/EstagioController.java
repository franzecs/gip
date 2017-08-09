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

import com.ikytus.gip.model.Aluno;
import com.ikytus.gip.model.Estagio;
import com.ikytus.gip.repository.EstagioRepository;
import com.ikytus.gip.service.EstagioService;

@Controller
@RequestMapping("/gip/npj/estagio")
public class EstagioController{
	
	
	@Autowired
	private EstagioRepository estagioRepository;
	
	@Autowired
	private EstagioService estagioService;
	
	@GetMapping("/novoEstagio")
	public ModelAndView novo(Estagio estagio){
		ModelAndView mv = new ModelAndView("npj/cadastroEstagio");
		mv.addObject(estagio);
		return mv;
	}
	
	@PostMapping("/novoEstagio")
	public ModelAndView salvar(@Valid Estagio estagio, Aluno aluno, BindingResult result, RedirectAttributes atributos){
		if(result.hasErrors()){
			return novo(estagio);
		}
		estagioService.salvar(estagio, aluno);
		atributos.addFlashAttribute("mensagem","Estágio salvo com sucesso!");
		return new ModelAndView("redirect:/gip/npj/estagio/novoEstagio");
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable Long codigo){
		Estagio estagio = estagioRepository.findOne(codigo);
		return novo(estagio);
	}
		
	
	@DeleteMapping("/{codigo}")
	public ModelAndView deletar(@PathVariable Long codigo, RedirectAttributes atributos){
		
		estagioRepository.delete(codigo);
		
		atributos.addFlashAttribute("mensagem","Estagio removido com sucesso!");
		return new ModelAndView("redirect:/gip/npj/aluno/");
	}
	
}
