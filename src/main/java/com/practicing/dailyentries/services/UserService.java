package com.practicing.dailyentries.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practicing.dailyentries.dto.UserDTO;
import com.practicing.dailyentries.entities.User;
import com.practicing.dailyentries.repositories.UserRepository;
import com.practicing.dailyentries.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		try {
			Optional<User> result = repository.findById(id);
			User user = result.get();
			return new UserDTO(user);
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("Recurso não encontrado.");
		}
	}

}
