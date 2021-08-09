package com.trnetwork.ws;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trnetwork.model.Subject;
import com.trnetwork.repository.SubjectRepository;

import ch.qos.logback.core.joran.conditional.IfAction;

@Service
public class SubjectService {
	private final SubjectRepository subjectRepository;
	
	@Autowired
	public SubjectService(SubjectRepository subjectRepository) {
		this.subjectRepository=subjectRepository;
	}

	public List<Subject> getSubject() {
		// TODO Auto-generated method stub
		return subjectRepository.findAll();
	}

	public void addNewSubject(Subject subject) {
		Optional<Subject> subjectOptional = subjectRepository
				.findSubjectByName(subject.getName());
		if (subjectOptional.isPresent()) {
			throw new IllegalStateException("name taken");
		}
		subjectRepository.save(subject);
		//findSubjectByName
	}
	
	public void deleteSubject(Long subjectId) {
		boolean exists = subjectRepository.existsById(subjectId);
		if (!exists) {
			throw new IllegalStateException("The subject with id "+ subjectId
					+"doesn't exists");
		}
		subjectRepository.deleteById(subjectId);
	}
	/* business logic*/
	@Transactional
	public void updateSubject(Long subjectId, String name, String ranking) {
		Subject subject = subjectRepository.findById(subjectId).orElseThrow(()-> new IllegalStateException(
				"The subject with id"+subjectId+"doesn't exist"));
		if (name!=null && name.length()>0 && !Objects.equals(subject.getName(), name)) {
			subject.setName(name);
		}
		if (ranking!=null && ranking.length()>0 && !Objects.equals(subject.getRanking(),ranking)) {
			subject.setRanking(ranking);;
		}
		
		
	}
	
	
	
}
