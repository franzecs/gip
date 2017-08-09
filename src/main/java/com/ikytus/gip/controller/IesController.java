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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ikytus.gip.model.Ies;
import com.ikytus.gip.repository.IesRepository;
import com.ikytus.gip.repository.filter.Filter;
import com.ikytus.gip.service.IesService;
import com.ikytus.gip.util.GravarImagem;

@Controller
@RequestMapping("/gip/administrador/ies")
public class IesController {
	
	@Autowired
	private IesRepository repository;
		
	@Autowired
	private IesService service;
	
	@Autowired
	private GravarImagem gi;
	
	private String foto;
	
	
				
	@GetMapping("/novaIes")
	public ModelAndView novo(Ies ies){
		ModelAndView mv = new ModelAndView("config/cadastroIes");
		mv.addObject(ies);
		return mv;
	}
	
	@PostMapping("/novaIes")
	public ModelAndView salvar(@RequestParam("file") MultipartFile file,
								@Valid Ies ies, BindingResult result, RedirectAttributes atributos){
		if(result.hasErrors()){
			return novo(ies);
		}
		
		foto = gi.gravaBase64(file);
		
		if(foto.isEmpty()){
			service.salvar(ies);
		}else{
			foto = "data:image/png;base64," + foto;
			service.salvar(ies, foto);
		}
				
		atributos.addFlashAttribute("mensagem","Ies salva com sucesso!");
		return new ModelAndView("redirect:/gip/administrador/ies/novaIes");
	}
			
	@GetMapping()
	public ModelAndView pesquisa (Filter filtrar){
		ModelAndView mv = new ModelAndView("config/consultaIes");
		mv.addObject("listaies", repository.findAll());
		return mv;
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable Long codigo){
		Ies ies = repository.findOne(codigo); 
		return novo(ies);
	}
	
	@DeleteMapping("/{codigo}")
	public ModelAndView deletar(@PathVariable Long codigo, RedirectAttributes atributos){
		
		repository.delete(codigo);
		
		atributos.addFlashAttribute("mensagem","IES removida com sucesso!");
		return new ModelAndView("redirect:/gip/administrador/ies");
	}
}