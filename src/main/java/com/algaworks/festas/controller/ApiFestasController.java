package com.algaworks.festas.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.festas.models.Festa;
import com.algaworks.festas.repository.Festas;

@RestController
@RequestMapping("/api/festas")
public class ApiFestasController {
	
	@Autowired
	Festas festas;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Collection <Festa> allFestas() {
		return festas.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional <Festa> oneFesta(@PathVariable("id") Long id){
		return festas.findById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeFesta(@PathVariable("id") Long id) {
		Optional<Festa> f = festas.findById(id);
		if (f == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		festas.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public  ResponseEntity<?> saveFesta(@RequestBody Festa festa) {
		return new ResponseEntity<Festa> (festas.save(festa), HttpStatus.OK);
	}

}
