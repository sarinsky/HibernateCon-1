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

import com.trnetwork.model.Rol;
import com.trnetwork.ws.RolService;

@RestController
@RequestMapping("api/rol")
public class RolController {
	
	private final RolService rolService;
	@Autowired
	public RolController(RolService rolService) {
		this.rolService= rolService;
	}
	
	@GetMapping
	public List<Rol> getRol(){
		return rolService.getRols();
	}
	@PostMapping
	public void registerNewRol(@RequestBody Rol rol) {
		rolService.addNewRol(rol);
	}
	
	@DeleteMapping(path = "{rolId}")
	public void deleteRol(@PathVariable("rolId") Long rolId) {
		rolService.deleteRol(rolId);
	}
	@PutMapping(path = "{rolId}")
	public void updateRol(
			@PathVariable("rolId") Long rolId,
			@RequestParam(required = false) String name) {
		rolService.updateRol(rolId, name);
	}
}
