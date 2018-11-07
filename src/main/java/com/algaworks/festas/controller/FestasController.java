package com.algaworks.festas.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.algaworks.festas.models.Festa;
import com.algaworks.festas.models.Upload;
import com.algaworks.festas.repository.Festas;
import com.algaworks.festas.repository.Uploads;

@Controller
@RequestMapping("/festas")
public class FestasController {

	@Autowired
	Festas festas;

	@Autowired 
	Uploads uploads;

	@RequestMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("FestasListagem.html");
		mv.addObject(new Festa());
		mv.addObject(new Upload());
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
		mv.addObject(new Upload());
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

	@RequestMapping(value="/image2",method=RequestMethod.POST)
	public String storeImage(Upload u) {
		//uploads.save(u);
		return "redirect:/festas";
	}

	@RequestMapping(value="/image",method=RequestMethod.POST)
	public String uploadMultipartFile(@RequestParam("file") MultipartFile file,@RequestParam("item_id") String id) {
		if (file.isEmpty()) {
			//redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:/";
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get("./image/" + id + file.getOriginalFilename());
			Files.write(path, bytes);
			//redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/festas";
	}





}