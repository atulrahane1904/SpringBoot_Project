package com.personal_project.bloging_app.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

	@Column(name = "postContent", length = 10000)
	private String content;
	@Column(name = "postAddedImage", nullable = false)
	private Date addedDate;
	@Column(name = "imageName", nullable = false)
	private String imageName;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JsonIgnore
	private Catagory catagory;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
//	@Override
//	public String toString() {
//		return "Post [postId=" + postId + ", title=" + title + ", content=" + content + ", addedDate=" + addedDate
//				+ ", imageName=" + imageName + "]";
//	}

}
