package com.personal_projet.spring_bloging_app.util;

import lombok.Data;

@Data
public class ResponseStructure<T> {

	private String message;
	private int statuscode;
	private T data;
	
	
}
