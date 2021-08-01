package com.trnetwork.ws;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trnetwork.model.Rol;
import com.trnetwork.model.Subject;
import com.trnetwork.repository.RolRepository;

@Service
public class RolService {
	private final RolRepository rolRepository;
	@Autowired
	public RolService(RolRepository rolRepository) {
		this.rolRepository= rolRepository;
	}
	
	public List<Rol> getRols(){
		return rolRepository.findAll();
	}
	
	public void addNewRol(Rol rol) {
		Optional<Rol> rolOptional= rolRepository
				.findRolByName(rol.getName());
		if (rolOptional.isPresent()) {
			throw new IllegalStateException("ROL TAKEN");
		}
		rolRepository.save(rol);
	}
	
	public void deleteRol(Long rolId) {
		boolean exists= rolRepository.existsById(rolId);
		if (!exists) {
			throw new IllegalStateException("ROL WITH ID: "+rolId+"DOESN'T EXIST");
		}
		rolRepository.deleteById(rolId);
	}
	@Transactional
	public void updateRol(Long rolId, String name) {
		Rol rol = rolRepository.findById(rolId).orElseThrow(()->new IllegalStateException(
				"ROL WITH THIS ID: "+rolId+"DOESN'T EXIST"));
		if (name != null && name.length()>0 && !Objects.equals(rol.getName(), name)) {
			rol.setName(name);
		}
	}
}
