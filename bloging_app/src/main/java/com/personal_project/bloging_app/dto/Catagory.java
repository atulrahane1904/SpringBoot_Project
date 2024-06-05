package com.personal_project.bloging_app.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Catagory {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name = "categoryTitle")
	private String title;
	@Column(name = "categoryDescription")
	private String description;
	@OneToMany(mappedBy = "catagory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> posts;

}
