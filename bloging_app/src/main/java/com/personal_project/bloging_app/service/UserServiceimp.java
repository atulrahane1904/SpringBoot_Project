package com.personal_project.bloging_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.personal_project.bloging_app.dao.UserDao;
import com.personal_project.bloging_app.dto.User;
import com.personal_project.bloging_app.util.ResponseStructure;
import com.ty.springboot_hospital_app.dto.Person;
import com.ty.springboot_hospital_app.service.exception.IdNotFoundException;

@Service
public class UserServiceimp implements UserService {
	@Autowired
	private UserDao userdao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		// TODO Auto-generated method stub
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setMessage("Successfully Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(userdao.saveUser(user));
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> findUser(int id) {
		// TODO Auto-generated method stub
		User user = userdao.findUserById(id);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (user != null) {
			structure.setMessage(" Found Successfully ");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
		} else {
			throw new com.personal_project.bloging_app.exception.IdNotFoundException("Id not found for Person");
		}
	}

	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		// TODO Auto-generated method stub
		User user = userdao.deleteUser(id);
		if (user != null) {
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setMessage("Succesfully Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new com.personal_project.bloging_app.exception.IdNotFoundException(
				"Person With this Id " + id + " Not Found ");
	}


	public ResponseEntity<ResponseStructure<List<User>>> getAllUser() {
		// TODO Auto-generated method stub
		
		  List<User> allUsers = userdao.getAllUsers();
		  ResponseStructure<List<User>> structure = new ResponseStructure<>();
		  if (allUsers!=null) {
			  structure.setStatus(HttpStatus.FOUND.value());
	            structure.setData(allUsers);
		        structure.setMessage("All users Found successfully");
		       return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.OK);

		}else{ throw new com.personal_project.bloging_app.exception.IdNotFoundException("User Not Found");
			}
		}

	

	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user) {
		// TODO Auto-generated method stub
		User user2 = userdao.userUpdate(id,user);
		ResponseStructure<User> structure=new ResponseStructure<User>();
	  if (user2!=null) {
		structure.setData(user2);
		structure.setMessage("User Update Succesfully");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}else {
	   throw new com.personal_project.bloging_app.exception.IdNotFoundException("User With this id "+id+" is not found");	
	}
	}



	

}
