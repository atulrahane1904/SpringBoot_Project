package com.personal_projet.spring_bloging_app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personal_projet.spring_bloging_app.dto.User;
import com.personal_projet.spring_bloging_app.service.UserServiceImp1;
import com.ty.springboot_hospital_app.dto.Person;
import com.ty.springboot_hospital_app.util.ResponseStructure;


@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
private UserServiceImp1 service;
@PostMapping
public com.personal_projet.spring_bloging_app.util.ResponseStructure<User> saveUser(@RequestBody User user) {
	return service.saveUser(user);
}

@GetMapping
public ResponseEntity<com.personal_projet.spring_bloging_app.util.ResponseStructure<User>> findUser( @RequestParam String userId) {
	
	return service.getUser(userId);
}

@PutMapping
public ResponseEntity<com.personal_projet.spring_bloging_app.util.ResponseStructure<User>> updateUser(@RequestParam String userId, @RequestBody  User user) {
	
	return service.updateUser(userId , user);
}
@GetMapping("/find/id")
public ResponseEntity<com.personal_projet.spring_bloging_app.util.ResponseStructure<User>> findUserById(@RequestParam int id) {
	return service.findUserById(id);
}
}
	

