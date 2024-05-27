package com.personal_projet.spring_bloging_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.personal_projet.spring_bloging_app.dao.UserDao;
import com.personal_projet.spring_bloging_app.dto.User;
import com.personal_projet.spring_bloging_app.exception.ResourceNotFoundException;
import com.personal_projet.spring_bloging_app.util.ResponseStructre;
import com.ty.springboot_hospital_app.dto.Address;
import com.ty.springboot_hospital_app.dto.Person;
import com.ty.springboot_hospital_app.service.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructure;

@Service
public class UserServiceImp1 implements UserServicee {
	@Autowired
	private UserDao dao;
//	

	public com.personal_projet.spring_bloging_app.util.ResponseStructure<User> saveUser(User user) {
//	    com.personal_projet.spring_bloging_app.util.ResponseStructure<User> responseStructure = new com.personal_projet.spring_bloging_app.util.ResponseStructure()<>();
//	    responseStructure.setMessage("Successfully Saved");
//	    responseStructure.setStatuscode(HttpStatus.CREATED.value());
//	    responseStructure.setData(user);
//	    dao.saveUser(user); // Assuming this method works as expected
//	    return responseStructure;
		com.personal_projet.spring_bloging_app.util.ResponseStructure<User> structure = new com.personal_projet.spring_bloging_app.util.ResponseStructure<>();
		structure.setMessage("Succesfully Saved");
		structure.setData(user);
		structure.setStatuscode(HttpStatus.CREATED.value());
		dao.saveUser(user);
		return structure;

	}

	public ResponseEntity<com.personal_projet.spring_bloging_app.util.ResponseStructure<User>> updateUser(String userId,
			User user) {

		com.personal_projet.spring_bloging_app.util.ResponseStructure<User> structure = new com.personal_projet.spring_bloging_app.util.ResponseStructure<>();

		User user1 = dao.findUser(userId);
		if (user != null) {
			user.setId(user1.getId());
			structure.setMessage("Found Succesfully");
			structure.setStatuscode(HttpStatus.FOUND.value());
			structure.setData(user);
			return new ResponseEntity<com.personal_projet.spring_bloging_app.util.ResponseStructure<User>>(structure,
					HttpStatus.FOUND);
//		    return structure;
		} else {
			throw new ResourceNotFoundException("Id not found for Person");

		}
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub

	}

	public ResponseEntity<com.personal_projet.spring_bloging_app.util.ResponseStructure<User>> getUser(String userId) {
		// TODO Auto-generated method stub
		com.personal_projet.spring_bloging_app.util.ResponseStructure<User> structure = new com.personal_projet.spring_bloging_app.util.ResponseStructure<>();

		User user = dao.findUser(userId);
		if (user != null) {
			structure.setMessage("Found Succesfully");
			structure.setStatuscode(HttpStatus.FOUND.value());
			structure.setData(user);
			return new ResponseEntity<com.personal_projet.spring_bloging_app.util.ResponseStructure<User>>(structure,
					HttpStatus.FOUND);
//		    return structure;
		} else {
			throw new ResourceNotFoundException("User with this id " +userId+ " is not found");

		}
	}

	@Override
	public ResponseEntity<com.personal_projet.spring_bloging_app.util.ResponseStructure<User>> updateUser(int id,
			User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<com.personal_projet.spring_bloging_app.util.ResponseStructure<User>> findUserById(int id) {
		// TODO Auto-generated method stub
		com.personal_projet.spring_bloging_app.util.ResponseStructure<User> structure = new com.personal_projet.spring_bloging_app.util.ResponseStructure<User>();

		User user = dao.findUser(id);
		if (user != null) {
			structure.setMessage("Found Sucdcesfully");
			structure.setStatuscode(HttpStatus.FOUND.value());
			structure.setData(user);
			return new ResponseEntity<com.personal_projet.spring_bloging_app.util.ResponseStructure<User>>(structure,
					HttpStatus.FOUND);
		}else {
			throw new ResourceNotFoundException("User With this id is not present");
		}

		
	}

}
