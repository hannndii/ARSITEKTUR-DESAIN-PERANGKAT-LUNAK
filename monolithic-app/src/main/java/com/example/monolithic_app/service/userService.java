package com.example.monolithic_app.service;

import com.example.monolithic_app.model.user;
import com.example.monolithic_app.repository.userRepository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import java.util.List; 
import java.util.Optional;
@Service
public class userService {
	@Autowired
	private userRepository userRepository;
	public List<user> getAllUsers() { 
	
		return userRepository.findAll();
	}
	
	public Optional<user> getUserById(Long id) { 
	
		return userRepository.findById(id);
	}
	
	public user createUser(user user) { 
	
		return userRepository.save(user);
	}
	
	public void deleteUser(Long id) { 
	
		userRepository.deleteById(id);
	}
	
	public user updateUser(Long id, user userDetails) {
	    return userRepository.findById(id).map(user -> {
	        user.setName(userDetails.getName());
	        user.setEmail(userDetails.getEmail());
	        return userRepository.save(user);
	    }).orElse(null);
	}

}
