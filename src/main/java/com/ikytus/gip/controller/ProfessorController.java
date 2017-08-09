package com.ikytus.gip.controller;

import java.util.HashMap;
import java.util.Map;

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

import com.ikytus.gip.model.Professor;
import com.ikytus.gip.repository.ProfessorRepository;
import com.ikytus.gip.repository.filter.Filter;
import com.ikytus.gip.service.ProfessorService;

@Controller
@RequestMapping("/gip/professor")
public class ProfessorController{
	
	@Autowired
	private ProfessorRepository professsorRepository;
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/novoProfessor")
	public ModelAndView novo(Professor professor){
		ModelAndView mv = new ModelAndView("professor/cadastroProfessor");
		mv.addObject(professor);
		return mv;
	}
	
	@PostMapping("/novoProfessor")
	public ModelAndView salvar(@Valid Professor professor, BindingResult result, RedirectAttributes atributos){
		if(result.hasErrors()){
			return novo(professor);
		}
		professorService.salvar(professor);
		atributos.addFlashAttribute("mensagem","Professor salvo com sucesso!");
		return new ModelAndView("redirect:/gip/professor/novoProfessor");
	}
			
	@GetMapping()
	public ModelAndView pesquisa (Filter filtrar){
		ModelAndView mv = new ModelAndView("professor/consultaProfessor");
		mv.addObject("listaprofessor", professsorRepository.findBySituacaoOrderByNome("Ativo"));
		return mv;
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable Long codigo){
		Professor professor = professsorRepository.findOne(codigo); 
		return novo(professor);
	}
		
	
	@DeleteMapping("/{codigo}")
	public ModelAndView deletar(@PathVariable Long codigo, RedirectAttributes atributos){
		
		professsorRepository.delete(codigo);
		
		atributos.addFlashAttribute("mensagem","Professor removido com sucesso!");
		return new ModelAndView("redirect:/gip/professor");
	}
	
	@GetMapping("/relatorio")
	public ModelAndView relatorio(){
				
		Map<String, Object> parametros = new HashMap<>();
		
		parametros.put("format", "pdf");
					
		return new ModelAndView("relatorio_professores", parametros);
	}
	
}
