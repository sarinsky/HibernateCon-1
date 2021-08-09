package com.trnetwork.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.trnetwork.model.HorarioMateria;

import com.trnetwork.repository.HMateriaRepository;

@Service
public class HMateriaService {
	private final HMateriaRepository hmRepository;
	@Autowired
	public HMateriaService(HMateriaRepository hMateriaRepository) {
		this.hmRepository=hMateriaRepository;
	}
	
	public List<HorarioMateria> getHMaterias() {
		// TODO Auto-generated method stub
		return hmRepository.findAll();
	}
	
	public void addNewHm(HorarioMateria horarioMateria) {
		System.out.println("eeeee");
		System.out.println(horarioMateria.toString());
		Optional<HorarioMateria> hmOptiona=hmRepository
				.findHorarioMateriaById(1L);
		System.out.println("llegué");
		if (hmOptiona.isPresent()) {
			throw new IllegalStateException("hm taken");
		}
		System.out.println();
		System.out.println(hmOptiona.toString());
		hmRepository.save(horarioMateria);
		
	}
	
	/*public ResponseEntity<HorarioMateria> createHm(@RequestBody HorarioMateria horarioMateria) {
		try {
			HorarioMateria horarioMateria2=hmRepository
					.save(new HorarioMateria(horarioMateria.getHorario(), horarioMateria.getNoControl(),
							horarioMateria.getCve_mat()), false);
					return new ResponseEntity<>(horarioMateria2, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
	
	public void deleteHm(Long hmId) {
		//studentRepository.findAllById(studentId);
			boolean exists = hmRepository.existsById(hmId);
			if (!exists) {
				throw new IllegalStateException("student with id "+ hmId
						+"doesn't exists");
			}
		hmRepository.deleteById(hmId);
	}
}
