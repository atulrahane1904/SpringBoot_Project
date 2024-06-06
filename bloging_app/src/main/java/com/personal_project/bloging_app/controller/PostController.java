package com.personal_project.bloging_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personal_project.bloging_app.dto.Post;
import com.personal_project.bloging_app.service.PostService;
import com.personal_project.bloging_app.service.PostServiceImp;
import com.personal_project.bloging_app.util.PostResponse;
import com.personal_project.bloging_app.util.ResponseStructure;

import jakarta.validation.Valid;

@RequestMapping("/post")
@RestController
public class PostController {
	@Autowired
	private PostServiceImp postService;

// save post
	@PostMapping
	public ResponseEntity<ResponseStructure<Post>> savePost(@Valid @RequestBody Post post, @RequestParam int categoryId,
			@RequestParam int userId) {
		return postService.savePost(post, categoryId, userId);
	}

// get all Post by userId
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Post>>> getAllPostByUser(@RequestParam int userid) {
		return postService.getAllPostByUser(userid);
	}

// update post using postId
	@PutMapping
	public ResponseEntity<ResponseStructure<Post>> updatePost(@RequestParam int postId, @RequestBody Post post) {
		return postService.updatePost(postId, post);
	}

// delete post using postId
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Post>> deletePost(@RequestParam int postId) {
		return postService.deletePost(postId);
	}

//get post by id
	@GetMapping("/postid")
	public ResponseEntity<ResponseStructure<Post>> findPost(@RequestParam int postId) {
		return postService.findPost(postId);
	}
	
// get  all post by categpryId
@GetMapping("/allPost/categoryId")
public ResponseEntity<ResponseStructure<List<Post>>> getAllPostByCategory( @RequestParam int  CategoryId) {
	return  postService.getAllPostByCategory(CategoryId);
}

@GetMapping("/all")
public ResponseEntity<PostResponse<List<Post>>> getAllPost( @RequestParam (value = "PageNumber",defaultValue = "0",required = false) int PageNumber,
		@RequestParam(  value = "PageSize", defaultValue =  "2",required = false ) int PageSize ){
	return postService.getAllPost(PageNumber,PageSize);
	
}
}
