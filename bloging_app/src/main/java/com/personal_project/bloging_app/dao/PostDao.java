package com.personal_project.bloging_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personal_project.bloging_app.dto.Post;
import com.personal_project.bloging_app.repo.PostRepo;

@Repository
public class PostDao {
@Autowired
private PostRepo postrepo;
public Post savePost(Post post) {
	return postrepo.save(post);
}

}
