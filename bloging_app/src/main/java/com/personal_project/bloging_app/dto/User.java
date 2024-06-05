package com.personal_project.bloging_app.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
	@Column(name = "userEmail", unique = true)
	@NotBlank(message = "email can't be blank")
	private String email;
//		@NotBlank(message = "contect no can't be blank")
	@Column(name = "userPhone", unique = true)
	private long phone;
//		@NotBlank(message = "password can't be blank")
	@Column(name = "userPassword")
	private String password;

	@Column(name = "userAbout")
	private String about;
  @OneToMany(mappedBy = "user")
  @JsonBackReference
	private List<Post> posts;

}
