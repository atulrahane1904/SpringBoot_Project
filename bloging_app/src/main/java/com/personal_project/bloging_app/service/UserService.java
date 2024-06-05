package com.personal_project.bloging_app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.personal_project.bloging_app.dto.User;
import com.personal_project.bloging_app.util.ResponseStructure;

public interface UserService {

	ResponseEntity<ResponseStructure<User>> saveUser(User user);

	ResponseEntity<ResponseStructure<User>> deleteUser(int id);

	ResponseEntity<ResponseStructure<User>> updateUser(int id, User user);
	
	ResponseEntity<ResponseStructure<List <User>>> getAllUser();
	

}
