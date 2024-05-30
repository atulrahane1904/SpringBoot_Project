package com.personal_project.bloging_app.dto;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "userInfo")
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
//		@NotBlank(message = "contect no can't be blank")
		@Column(name = "userPhone",unique = true)
		private long phone;
//		@NotBlank(message = "password can't be blank")
		@Column(name = "userPassword")
		private String password;

		@Column(name = "userAbout")
		private String about;
//		@Autowired
//		@OneToMany(cascade = CascadeType.ALL)
//		private List<Post> postlist;
}
