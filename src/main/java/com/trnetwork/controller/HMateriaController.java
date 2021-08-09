package com.trnetwork.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trnetwork.model.HorarioMateria;
import com.trnetwork.model.Student;
import com.trnetwork.repository.HMateriaRepository;
import com.trnetwork.ws.HMateriaService;

import oracle.jdbc.proxy.annotation.Post;
@RestController
@RequestMapping("api/hmateria")
public class HMateriaController {
	private final HMateriaService hMateriaService;
	
	@Autowired
	public  HMateriaController(HMateriaService hMateriaService) {
		this.hMateriaService=hMateriaService;
	}
	@GetMapping
	public List<HorarioMateria> getHMaterias(){
		return hMateriaService.getHMaterias();
	}
	
	@PostMapping
	public void registerNewHm(@RequestBody HorarioMateria horarioMateria) {
		hMateriaService.addNewHm(horarioMateria);
	}
	
	@DeleteMapping(path = "{hmId}")
	public void deleteHm(@PathVariable("hmId") Long hmId) {
		//hMateriaService.deleteHm(hmId);
	}
	@Autowired
	HMateriaRepository repository;
	
	@PutMapping("{hmId}")
	public ResponseEntity<HorarioMateria> updateTutorial(@PathVariable("hmId") long id, 
			@RequestParam HorarioMateria horarioMateria){
			//@RequestParam(required= false) String //subject) {
		Optional<HorarioMateria> hmData=  repository.findById(id);
		if (hmData.isPresent()) {
			HorarioMateria _hm=hmData.get();
			_hm.setHorario(horarioMateria.getHorario());
			_hm.setCve_mat(horarioMateria.getCve_mat());
			_hm.setNoControl(horarioMateria.getNoControl());
			return new ResponseEntity<>(repository.save(_hm), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

