package com.personal_project.bloging_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal_project.bloging_app.dto.Post;
import com.personal_project.bloging_app.service.PostService;
import com.personal_project.bloging_app.util.ResponseStructure;

import jakarta.validation.Valid;

@RequestMapping
@RestController("/post")
public class PostController {
@Autowired
private PostService postService;	
	
@PostMapping
public ResponseEntity<ResponseStructure<Post>> savePost(@Valid @RequestBody Post post) {
	return postService.savePost(post);
}
}
