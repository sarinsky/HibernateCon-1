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

import com.trnetwork.model.Subject;
import com.trnetwork.ws.SubjectService;

@RestController
@RequestMapping("api/subject")
public class SubjectController {
	
	private final SubjectService subjectService;
	
	@Autowired
	public SubjectController(SubjectService subjectService) {
		this.subjectService=subjectService;
	}
	
	@GetMapping //method get 
	public List<Subject> getSubject(){
		return subjectService.getSubject();
	}
	@PostMapping //add new register
	public void registerNewSubject(@RequestBody Subject subject) {
		subjectService.addNewSubject(subject);
	}
	@DeleteMapping(path = "{subjectId}")
	public void deleteSubject(@PathVariable("subjectId") Long subjectId) {
		subjectService.deleteSubject(subjectId);
	}
	@PutMapping(path= "{subjectId}")
	public void updateSubject(
			@PathVariable("subjectId") Long subjectId,
			@RequestParam(required = false) String name) {
		subjectService.updateSubject(subjectId, name);
	}
	
	
}
