package com.trnetwork.ws;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trnetwork.model.User;
import com.trnetwork.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}

	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	public void addNewUser(User user) {
		Optional<User> userOptional=userRepository
				.findUserByEmail(user.getEmail());
		if (userOptional.isPresent()) {
			throw new IllegalStateException("user taken");
		}
		System.out.println(user);
		userRepository.save(user);
	}

	public void deleteUser(Long userId) {
		boolean exists= userRepository.existsById(userId);
		if (exists) {
			throw new IllegalStateException("User with id: "+ userId
					+"doesn't exists");
		}
		userRepository.deleteById(userId);
	}
	@Transactional
	public void updateUser(Long userId, String email, String pwd) {
		
		User user= userRepository.findById(userId).orElseThrow(()->new
				IllegalStateException("USER WITH THIS ID: "+userId+" DOESN'T EXIST"));
		if (email!= null && email.length()>0 && !Objects.equals(user.getEmail(), email)) {
			user.setEmail(email);
		}
		if (pwd!=null && pwd.length()>0 && !Objects.equals(user.getPdw(), pwd)) {
			Optional<User> userOptional = userRepository.findUserByEmail(pwd);
			if (userOptional.isPresent()) {
				throw new IllegalStateException("EMAIL TAKEN");
			}
			user.setPdw(pwd);
		}
		
	}
	
	
	
}
