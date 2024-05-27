package com.personal_projet.spring_bloging_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal_projet.spring_bloging_app.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {



	User findByPhone(long phone);

	User findByEmail(String email);

}
