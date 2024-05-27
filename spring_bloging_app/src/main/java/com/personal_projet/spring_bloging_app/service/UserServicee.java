package com.personal_projet.spring_bloging_app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.personal_projet.spring_bloging_app.dto.User;
import com.personal_projet.spring_bloging_app.util.ResponseStructre;
import com.personal_projet.spring_bloging_app.util.ResponseStructure;

public interface UserServicee {

	public ResponseStructure<User> saveUser(User user);
	
	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user);
	
	public User getUserById(int id);
	public List<User> getAllUser();
	
	public void deleteUser(int id);
	
}
