package com.personal_projet.spring_bloging_app.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Component
@Table(name = "User_info")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "userName")
	@NotBlank(message = "name can't be blank")
	private String name;
	@Column(name = "userEmail",unique = true)
	@NotBlank(message = "email can't be blank")
	private String email;
//	@NotBlank(message = "contect no can't be blank")
	@Column(name = "userPhone",unique = true)
	private long phone;
//	@NotBlank(message = "password can't be blank")
	@Column(name = "userPassword")
	private String password;

	@Column(name = "userAbout")
	private String about;
	
	
}
