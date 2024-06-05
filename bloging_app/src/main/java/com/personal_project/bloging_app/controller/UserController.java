package com.personal_project.bloging_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personal_project.bloging_app.dto.User;
import com.personal_project.bloging_app.service.UserService;
import com.personal_project.bloging_app.service.UserServiceimp;
import com.personal_project.bloging_app.util.ResponseStructure;

@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
private UserServiceimp service; 
@PostMapping
public ResponseEntity<ResponseStructure<User>> saveUser( @RequestBody User user ) {
	return service.saveUser(user);
}
	
@GetMapping
public ResponseEntity<ResponseStructure<User>> findUser(@RequestParam  int id) {
 
	return service.findUser(id);
	
}
@DeleteMapping
public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam int id) {
  return service.deleteUser(id);	
}

@GetMapping("/all")
public ResponseEntity<ResponseStructure<List<User>>> getAllUser(){
	return  service.getAllUser();
	
}
@PutMapping
public ResponseEntity<ResponseStructure<User>> UpdateUser(@RequestParam  int id, @RequestBody User  user ) {    
	return service.updateUser(id,user);
}

//public ResponseEntity<ResponseStructure<User>> deleteAllUser() {
//	return service.deleteAllUser();
//;}
}
