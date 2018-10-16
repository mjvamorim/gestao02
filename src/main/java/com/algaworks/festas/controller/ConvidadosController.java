package com.algaworks.festas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.festas.models.Convidado;
import com.algaworks.festas.repository.Convidados;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {
	
	@Autowired
	Convidados convidados;
	
	@RequestMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ConvidadosListagem.html");
		mv.addObject(new Convidado());
		mv.addObject("convidados",convidados.findAll());
		return mv;
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public String gravar(Convidado c) {
		convidados.save(c);
		return "redirect:/convidados";
	}
}
