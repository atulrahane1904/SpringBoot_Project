package com.personal_project.bloging_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.personal_project.bloging_app.dao.PostDao;
import com.personal_project.bloging_app.dto.Post;
import com.personal_project.bloging_app.util.ResponseStructure;
@Service
public class PostService {
@Autowired 
private PostDao postdao;
	public ResponseEntity<ResponseStructure<Post>> savePost(Post post) {
		// TODO Auto-generated method stub
		ResponseStructure<Post> structure=new ResponseStructure<Post>();
		structure.setData(post);
		structure.setMessage("Post save Succesfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Post>>(structure,HttpStatus.CREATED);
	}

}
