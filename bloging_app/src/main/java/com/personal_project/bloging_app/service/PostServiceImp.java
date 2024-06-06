package com.personal_project.bloging_app.service;

import java.util.List;

import org.hibernate.cache.spi.entry.StructuredCacheEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.personal_project.bloging_app.dao.PostDao;
import com.personal_project.bloging_app.dto.Catagory;
import com.personal_project.bloging_app.dto.Post;
import com.personal_project.bloging_app.exception.IdNotFoundException;
import com.personal_project.bloging_app.util.PostResponse;
import com.personal_project.bloging_app.util.ResponseStructure;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class PostServiceImp implements PostService {
	@Autowired
	private PostDao postDao;

	@Override
	public ResponseEntity<ResponseStructure<Post>> savePost(Post post, int categoryId, int userId) {
		// TODO Auto-generated method stub
		Post post2 = postDao.savePost(post, categoryId, userId);
		ResponseStructure<Post> structure = new ResponseStructure<>();
		if (post2 != null) {
			structure.setMessage("Successfully Saved");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(post2);
			return new ResponseEntity<ResponseStructure<Post>>(structure, HttpStatus.CREATED);
		} else {
			structure.setMessage("Fail to save Saved");
			structure.setStatus(HttpStatus.BAD_REQUEST.value());

			return new ResponseEntity<ResponseStructure<Post>>(structure, HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Post>> updatePost(int postId, Post post) {
		// TODO Auto-generated method stub
		ResponseStructure<Post> structure = new ResponseStructure<>();
		Post post2 = postDao.updatePost(postId, post);
		if (post2 != null) {
			structure.setMessage("Post Updated Succesufully");
			structure.setData(post2);
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Post>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Post With this id " + postId + " is not found");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Post>> findPost(int postId) {
		ResponseStructure<Post> structure = new ResponseStructure<>();
		Post post = postDao.findPost(postId);
		if (post != null) {
			structure.setMessage("Post Found Succesufully");
			structure.setData(post);
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Post>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Post Wiht this Post ID " + postId + " Is not Found ");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Post>> deletePost(int postId) {
		// TODO Auto-generated method stub
		ResponseStructure<Post> structure = new ResponseStructure<>();
		Post post = postDao.deletePost(postId);
		if (post != null) {
			structure.setMessage("Post deleted Succesufully");
			structure.setData(post);
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Post>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Post With this id " + postId + " is not found");
		}

	}

	@Override
	public ResponseEntity<ResponseStructure<List<Post>>> getAllPostByUser(int userId) {
		// TODO Auto-generated method stub
		ResponseStructure<List<Post>> structure = new ResponseStructure<>();
		List<Post> list = postDao.getAllPostByUser(userId);
		if (list.isEmpty()) {
			structure.setMessage("Post Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());

			return new ResponseEntity<ResponseStructure<List<Post>>>(structure, HttpStatus.NOT_FOUND);

		}
		structure.setMessage("Post Found Succesfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(list);
		return new ResponseEntity<ResponseStructure<List<Post>>>(structure, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Post>>> getAllPostByCategory(int categoryId) {
		// TODO Auto-generated method stub
		ResponseStructure<List<Post>> structure = new ResponseStructure<>();
		List<Post> list = postDao.getAllPostByCategory(categoryId);
		if (list.isEmpty()) {
			throw new IdNotFoundException("category Not Found With this categoryId " + categoryId);
		} else {
			structure.setMessage("Post Found Succesfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Post>>>(structure, HttpStatus.FOUND);
		}
	}

	

	public ResponseEntity<PostResponse<List<Post>>> getAllPost(int PageNumber, int PageSize) {
		// TODO Auto-generated method stub
		PostResponse<List<Post>> structure = new PostResponse<>();
		if (postDao.getAllPost(PageNumber,PageSize).isEmpty()) {
			Page<Post> allPost = postDao.getAllPost(PageNumber,PageSize);
			List<Post> content = allPost.getContent();
			System.out.println("In postServcieImp inside getalluser method inside if block");
			structure.setMessage("Post Not Found ");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setData(null);
			structure.setContent(content);
			structure.setLastPage(allPost.isLast());
			structure.setPageSize(allPost.getSize());
			structure.setTotalElement(allPost.getTotalElements());
			structure.setPageNumber(allPost.getNumber());
			structure.setTotalPages(allPost.getTotalPages());
			return new ResponseEntity<PostResponse<List<Post>>>(structure, HttpStatus.NOT_FOUND);
		} else {
			Page<Post> allPost = postDao.getAllPost(PageNumber,PageSize);
			List<Post> content = allPost.getContent();
			structure.setMessage("Post Found Succesfully ");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setContent(allPost.getContent());
			structure.setLastPage(allPost.isLast());
			structure.setPageSize(allPost.getSize());
			structure.setTotalElement(allPost.getTotalElements());
			structure.setPageNumber(allPost.getNumber());
			return new ResponseEntity<PostResponse<List<Post>>>(structure, HttpStatus.FOUND);
		}

	}

//	@Override
//	public ResponseEntity<ResponseStructure<Post>> deletePostByCategory(int categoryId) {
//		// TODO Auto-generated method stub
//		   postDao.deletePostByCategory(categoryId);
//		return null;
//	}


}
