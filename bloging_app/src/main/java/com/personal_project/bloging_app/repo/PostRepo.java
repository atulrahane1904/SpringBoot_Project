package com.personal_project.bloging_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal_project.bloging_app.dto.Post;

public interface PostRepo extends JpaRepository<Post, Integer> {

}
