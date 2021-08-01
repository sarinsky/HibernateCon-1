package com.trnetwork.ws;

import java.nio.charset.IllegalCharsetNameException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trnetwork.model.Docente;
import com.trnetwork.repository.DocenteRepository;
@Service
public class DocenteService {
	private final DocenteRepository docenteRepository;
	
	@Autowired
	public DocenteService(DocenteRepository docenteRepository) {
		this.docenteRepository=docenteRepository;
	}

	public List<Docente> getDocente() {
		// TODO Auto-generated method stub
		return docenteRepository.findAll();
	}

	public void addNewDocente(Docente docente) {
		// TODO Auto-generated method stub
		Optional<Docente> docenteOptional = docenteRepository
				.findDocenteByEmail(docente.getEmail());
		if (docenteOptional.isPresent()) {
			throw new IllegalStateException("EMAIL TAKEN");
		}
		docenteRepository.save(docente);
	}
	
	
	public 	void deleteDocente(Long docenteId) {
		boolean exists = docenteRepository.existsById(docenteId);
		if (!exists) {
			throw new IllegalStateException("DOCENTE WITH ID:" +docenteId+"DOENS'T EXIST");
		}
		docenteRepository.deleteById(docenteId);;
	}
	
	@Transactional	
	public void updateDocente(Long docenteId, String name, String email) {
		Docente docente = docenteRepository.findById(docenteId).orElseThrow(()->new IllegalStateException(
				"DOCENTE WITH THIS ID: "+docenteId+"doesn't exist"));
		if (name!= null && name.length()>0 && !Objects.equals(docente.getName(), name)) {
			docente.setName(name);
		}
		if (email != null && email.length()>0 && Objects.equals(docente.getEmail(), email)) {
			Optional<Docente> docenteOptional =docenteRepository.findDocenteByEmail(email);
			if (docenteOptional.isPresent()) {
				throw new IllegalStateException("EMAIL TAKEN ");
			}
		}
		
	}

}
