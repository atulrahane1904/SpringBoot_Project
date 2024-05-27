package com.personal_projet.spring_bloging_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;






@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<com.personal_projet.spring_bloging_app.util.ResponseStructure<String>> ResourceNotFoundException(ResourceNotFoundException exception) {
		com.personal_projet.spring_bloging_app.util.ResponseStructure<String> structure = new com.personal_projet.spring_bloging_app.util.ResponseStructure<>();
		structure.setMessage(exception.getMessage());
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		structure.setData("No Id found");
		return new ResponseEntity<com.personal_projet.spring_bloging_app.util.ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
 
	
		
}

