package com.personal_project.bloging_app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.personal_project.bloging_app.dto.Post;
import com.personal_project.bloging_app.util.ResponseStructure;

public interface PostService {

	ResponseEntity<ResponseStructure<Post>> savePost(Post post, int categoryId, int userId);

	ResponseEntity<ResponseStructure<Post>> updatePost(int postId, Post post);

	ResponseEntity<ResponseStructure<Post>> deletePost(int id);

//	ResponseEntity<ResponseStructure<Post>> deletePostByCategory(int categoryId);

	ResponseEntity<ResponseStructure<List<Post>>> getAllPostByUser(int userId);

	ResponseEntity<ResponseStructure<List<Post>>> getAllPostByCategory(int categoryId);

	ResponseEntity<ResponseStructure<Post>> findPost(int postId);

	public ResponseEntity<ResponseStructure<List<Post>>> getAllPost(int PageNumber,int PageSize);
}
