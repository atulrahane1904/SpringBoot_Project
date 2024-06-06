package com.personal_project.bloging_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.personal_project.bloging_app.dto.Catagory;
import com.personal_project.bloging_app.dto.Post;
import com.personal_project.bloging_app.dto.User;
import com.personal_project.bloging_app.repo.CategoryRepo;
import com.personal_project.bloging_app.repo.PostRepo;
import com.personal_project.bloging_app.repo.UserRepo;

@Repository
public class PostDao {
	@Autowired
	private PostRepo postrepo;
	@Autowired
	private UserRepo userrepo;
	@Autowired
	private CategoryRepo categoryrepo;

	public Post savePost(Post post, int categoryId, int userId) {
//	
		if (userrepo.findById(userId).isPresent() && categoryrepo.findById(categoryId).isPresent()) {
			User user = userrepo.findById(userId).get();
			Catagory category = categoryrepo.findById(categoryId).get();
			post.setCatagory(category);
			post.setUser(user);
			postrepo.save(post);

			return post;
		} else {

			return null;
		}
	}

	public List<Post> getAllPostByUser(int userId) {
		// TODO Auto-generated method stub
		if (userrepo.findById(userId).isPresent()) {
			User user = userrepo.findById(userId).get();
			return user.getPosts();
		} else {
			return null;
		}

	}

	public Post updatePost(int postId, Post post) {
		// TODO Auto-generated method stub
		if (postrepo.findById(postId).isPresent()) {
			Post post2 = postrepo.findById(postId).get();
			post.setPostId(postId);
			post.setUser(post2.getUser());
			post.setCatagory(post2.getCatagory());
			postrepo.save(post);
			return post;
		} else {
			return null;
		}
	}

	public Post deletePost(int postId) {
		// TODO Auto-generated method stub
		if (postrepo.findById(postId).isPresent()) {
			Post post1 = postrepo.findById(postId).get();

			postrepo.deleteById(postId);
			return post1;
		} else {
			return null;
		}

	}

	public Post findPost(int postId) {
		// TODO Auto-generated method stub
		if (postrepo.findById(postId).isPresent()) {
			Post post = postrepo.findById(postId).get();
			return post;
		} else {
			return null;
		}
	}

	public List<Post> getAllPostByCategory(int categoryId) {
		// TODO Auto-generated method stub

		if (categoryrepo.findById(categoryId).isPresent()) {
			Catagory catagory = categoryrepo.findById(categoryId).get();
			return catagory.getPosts();
		} else {
			return null;
		}
	}

	public Page<Post> getAllPost(int PageNumber, int PageSize) {
		// TODO Auto-generated method stub
//        System.out.println("inside postDao class in getallPost");
	   Pageable page =PageRequest.of(PageNumber, PageSize);
		Page<Post> all = postrepo.findAll(page);
//		System.out.println(content);
//	
//		if (content!=null) {
//			return content;
//		}else {
//			return null;
//		}
//		List<Post> findAll = postrepo.findAll();
	
		if (all!=null) {
			return all;
			
		}else {
			return null;
		}
//		return postrepo.findAll(page).getContent();

	}

//
//	public List<Post> deletePostByCategory(int categoryId) {
//		// TODO Auto-generated method stub
//	if (categoryrepo.findById(categoryId).isPresent()) {
//		Optional<Catagory> category = categoryrepo.findById(categoryId);
//		categoryrepo.delete(category);
//	}
//	}

}
