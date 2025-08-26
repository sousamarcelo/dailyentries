package com.practicing.dailyentries.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practicing.dailyentries.dto.UserDTO;
import com.practicing.dailyentries.entities.Role;
import com.practicing.dailyentries.entities.User;
import com.practicing.dailyentries.projection.UserDetailsProjection;
import com.practicing.dailyentries.repositories.UserRepository;
import com.practicing.dailyentries.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService {
	
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
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAll(Pageable pageable){
		Page<User> page = repository.findAll(pageable);
		Page<UserDTO> result = page.map(x -> new UserDTO(x));
		return result;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<UserDetailsProjection> result = repository.searchUserAndRolesByEmail(username);
		if (result.size() == 0) {
			throw new UsernameNotFoundException("User not found");
		}
		
		User user = new User();
		user.setEmail(username);
		user.setPassword(result.get(0).getPassword());
		for(UserDetailsProjection projection : result) {
			user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
		}
		return user;
	}

}
