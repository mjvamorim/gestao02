package com.algaworks.festas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.festas.repository.Convidados;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {
	@Autowired
	Convidados convidados;
	
	@RequestMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ConvidadosListagem.html");
		mv.addObject("convidados",convidados.findAll());
		return mv;
	}
}
