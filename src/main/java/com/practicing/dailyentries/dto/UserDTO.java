package com.practicing.dailyentries.dto;

import java.util.ArrayList;
import java.util.List;

import com.practicing.dailyentries.entities.Role;
import com.practicing.dailyentries.entities.User;

public class UserDTO {
	
	private Long id;
	private String name;	
	private String email;
	private String phone;
	private String password;
	
	private List<Role> roles = new ArrayList<>();
	
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getEmail();
		email = entity.getEmail();
		phone = entity.getPhone();
		password = entity.getPassword();		
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}

	public List<Role> getRoles() {
		return roles;
	}
}
