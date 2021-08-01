package com.trnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trnetwork.model.Docente;
import com.trnetwork.ws.DocenteService;

@RestController
@RequestMapping(path = "api/docente")
public class DocenteController {
	private final DocenteService docenteService;
	
	@Autowired
	public DocenteController (DocenteService docenteService) {
		this.docenteService=docenteService;
	}
	@GetMapping
	public List<Docente> getDocente(){
		return docenteService.getDocente();
	}
	
	@PostMapping
	public void registerNewDocente(@RequestBody Docente docente) {
		docenteService.addNewDocente(docente);
	}
	@DeleteMapping(path = "{docenteId}")
	public void deleteDocente(@PathVariable("docenteId") Long docenteId) {
		docenteService.deleteDocente(docenteId);
	}
	@PutMapping(path = "{docenteId}")
	public void updateDocente(
			@PathVariable("docenteId") Long docenteId,
			@RequestParam(required=false) String name,
			@RequestParam(required = false) String email) {
		docenteService.updateDocente(docenteId, name, email);	
	}
	
	
	
	

}
