package com.algaworks.festas.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.festas.models.Convidado;
import com.algaworks.festas.repository.Convidados;

@RestController
@RequestMapping("/api/convidados")
public class ApiConvidadoController {

	@Autowired
	private Convidados convidados;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Collection<Convidado> listaConvidados() {
		return convidados.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Convidado> getConvidado(@PathVariable("id") Long id) {
		return this.convidados.findById(id);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Convidado>> listar() {
		return new ResponseEntity<List<Convidado>>(new ArrayList<Convidado>(convidados.findAll()), 
				HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeConvidado(@PathVariable("id") Long id) {
		Optional<Convidado> c = convidados.findById(id);
		if (c == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		convidados.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public  ResponseEntity<?> saveConvidado(@RequestBody Convidado convidado) {
		return new ResponseEntity<Convidado> (convidados.save(convidado), HttpStatus.OK);
	}

}
