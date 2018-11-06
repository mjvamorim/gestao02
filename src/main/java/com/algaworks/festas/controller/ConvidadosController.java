package com.algaworks.festas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.festas.models.Convidado;
import com.algaworks.festas.repository.Convidados;
import com.algaworks.festas.repository.Festas;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {
	
	@Autowired
	Convidados convidados;
	
	@Autowired 
	Festas festas;
	
	@RequestMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ConvidadosListagem.html");
		mv.addObject(new Convidado());
		mv.addObject("festas",festas.findAll());
		mv.addObject("convidados",convidados.findAll());
		return mv;
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public String gravar(Convidado c) {
		convidados.save(c);
		return "redirect:/convidados";
	}
	
	@RequestMapping(value="alterar/{id}")
	public ModelAndView alterar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("ConvidadosListagem.html");
		Convidado convidado = convidados.getOne(id);
		mv.addObject(convidado);
		mv.addObject("festas",festas.findAll());
		mv.addObject("convidados",convidados.findAll());
		return mv;
	}
	
	//Excluir
	@RequestMapping(value="/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		convidados.deleteById(id);
		//attributes.addFlashAttribute("mensagem", "Proprietario excluído com sucesso!");
		return "redirect:/convidados";
	}
	
}
