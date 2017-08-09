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
import com.ikytus.gip.repository.AlunoRepository;
import com.ikytus.gip.repository.EstagioRepository;
import com.ikytus.gip.repository.filter.Filter;
import com.ikytus.gip.service.AlunoService;
import com.ikytus.gip.service.EstagioService;

@Controller
@RequestMapping("/gip/npj/aluno")
public class AlunoController{
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private EstagioRepository estagioRepository;
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private EstagioService estagioService;
	
	private Aluno alunoselecionado;
	
				
	@GetMapping("/novoAluno")
	public ModelAndView novo(Aluno aluno){
		ModelAndView mv = new ModelAndView("npj/cadastroAluno");
		mv.addObject(aluno);
		if(aluno.getCodigo() != null){
			mv.addObject("listaestagio", estagioRepository.findByAluno(aluno));
		}
		return mv;
	}
	
	@PostMapping("/novoAluno")
	public ModelAndView salvar(@Valid Aluno aluno, BindingResult result, RedirectAttributes atributos){
		if(result.hasErrors()){
			return novo(aluno);
		}
		alunoService.salvar(aluno);
		atributos.addFlashAttribute("mensagem","Aluno salvo com sucesso!");
		return new ModelAndView("redirect:/gip/npj/aluno/novoAluno");
	}
			
	@GetMapping()
	public ModelAndView pesquisa (Filter filtrar){
		ModelAndView mv = new ModelAndView("npj/consultaAluno");
		mv.addObject("listaalunos", alunoRepository.findAll());
		return mv;
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable Long codigo){
		alunoselecionado = alunoRepository.findOne(codigo);
		return novo(alunoselecionado);
	}
		
	@GetMapping("/novoEstagio")
	public ModelAndView novoEstagio(Estagio estagio){
		ModelAndView mv = new ModelAndView("npj/cadastroEstagio");
		mv.addObject(estagio);
		mv.addObject(alunoselecionado);
		return mv;
	}
	
	@PostMapping("/novoEstagio")
	public ModelAndView salvar(@Valid Estagio estagio, BindingResult result, RedirectAttributes atributos){
		if(result.hasErrors()){
			return novoEstagio(estagio);
		}
		estagioService.salvar(estagio, alunoselecionado);
		atributos.addFlashAttribute("mensagem","Estágio salvo com sucesso!");
		return new ModelAndView("redirect:/gip/npj/estagio/novoEstagio");
	}
		
	
	
	@DeleteMapping("/{codigo}")
	public ModelAndView deletar(@PathVariable Long codigo, RedirectAttributes atributos){
		
		alunoRepository.delete(codigo);
		
		atributos.addFlashAttribute("mensagem","Aluno removido com sucesso!");
		return new ModelAndView("redirect:/gip/npj/aluno");
	}
	
}
