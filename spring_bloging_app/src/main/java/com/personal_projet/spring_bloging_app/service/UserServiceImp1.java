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
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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

@Override
public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
	// TODO Auto-generated method stub
	com.personal_projet.spring_bloging_app.util.ResponseStructure<User> structure=new com.personal_projet.spring_bloging_app.util.ResponseStructure<User>();
	structure.setData(user);
	structure.setMessage();
	structure.setStatuscode(HttpStatus.CREATED.value());
	dao.saveUser(user);
	return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
}

@Override
public ResponseEntity<com.personal_projet.spring_bloging_app.util.ResponseStructure<User>> updateUser(int id,
		User user) {
	// TODO Auto-generated method stub
	return null;
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


}
