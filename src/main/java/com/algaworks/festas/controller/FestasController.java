package com.algaworks.festas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.algaworks.festas.models.Festa;
import com.algaworks.festas.repository.Festas;

@Controller
@RequestMapping("/festas")
public class FestasController {
	
	@Autowired
	Festas festas;
	
	@RequestMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("FestasListagem.html");
		mv.addObject(new Festa());
		mv.addObject("festas",festas.findAll());
		return mv;
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public String gravar(Festa f) {
		festas.save(f);
		return "redirect:/festas";
	}
	
	@RequestMapping(value="alterar/{id}")
	public ModelAndView alterar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("FestasListagem.html");
		Festa festa = festas.getOne(id);
		mv.addObject(festa);
		mv.addObject("festas",festas.findAll());
		return mv;
	}
	
	//Excluir
	@RequestMapping(value="/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		festas.deleteById(id);
		//attributes.addFlashAttribute("mensagem", "Proprietario excluído com sucesso!");
		return "redirect:/festas";
	}
	
}