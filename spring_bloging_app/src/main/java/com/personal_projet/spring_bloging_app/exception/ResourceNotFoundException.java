package com.personal_projet.spring_bloging_app.exception;

public class ResourceNotFoundException extends RuntimeException {

	
	private String message = "User Not Found";

	@Override
	public String getMessage() {
		return message;
	}

	public ResourceNotFoundException(String message) {
		super();
		this.message = message;
	}

	public ResourceNotFoundException() {
		super();
	}

}
