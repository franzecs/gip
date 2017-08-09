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

import com.ikytus.gip.model.Curso;
import com.ikytus.gip.repository.CursoRepository;
import com.ikytus.gip.repository.IesRepository;
import com.ikytus.gip.repository.ProfessorRepository;
import com.ikytus.gip.repository.filter.Filter;
import com.ikytus.gip.service.CursoService;

@Controller
@RequestMapping("/gip/administrador/curso")
public class CursoController{
	
	@Autowired
	private CursoRepository repository;
	
	@Autowired
	private IesRepository iesRepository;
	
	@Autowired
	private ProfessorRepository professsorRepository;
	
	@Autowired
	private CursoService service;
	
	@GetMapping("/novoCurso")
	public ModelAndView novo(Curso curso){
		ModelAndView mv = new ModelAndView("config/cadastroCurso");
		mv.addObject(curso);
		mv.addObject("listaies", iesRepository.findAll());
		mv.addObject("coordenadores", professsorRepository.findByCoordenadorTrueOrderByNome());
		return mv;
	}
	
	@PostMapping("/novoCurso")
	public ModelAndView salvar(@Valid Curso curso, BindingResult result, RedirectAttributes atributos){
		if(result.hasErrors()){
			return novo(curso);
		}
		System.out.println(curso.getCoordenador());
		System.out.println(curso.getIes());
		service.salvar(curso);
		atributos.addFlashAttribute("mensagem","Curso salvo com sucesso!");
		return new ModelAndView("redirect:/gip/administrador/curso/novoCurso");
	}
			
	@GetMapping()
	public ModelAndView pesquisa (Filter filtrar){
		ModelAndView mv = new ModelAndView("config/consultaCurso");
		mv.addObject("listacurso", repository.findAll());
		return mv;
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable Long codigo){
		Curso curso = repository.findOne(codigo); 
		return novo(curso);
	}
		
	
	@DeleteMapping("/{codigo}")
	public ModelAndView deletar(@PathVariable Long codigo, RedirectAttributes atributos){
		
		repository.delete(codigo);
		
		atributos.addFlashAttribute("mensagem","Curso removido com sucesso!");
		return new ModelAndView("redirect:/gip/administrador/curso");
	}

	
}
