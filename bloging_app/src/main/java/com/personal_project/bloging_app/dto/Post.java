package com.personal_project.bloging_app.dto;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "post_info")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	@Column(name = "postTitle", length = 100, nullable = false)
	private String title;

	@Column(name = "postContent", length = 1000)
	private String content;

	private Date addedDate;
	private String imageName;
//	@ManyToOne
//	private Catagory catagory;
//
//	@ManyToOne
//	private User user;
}
