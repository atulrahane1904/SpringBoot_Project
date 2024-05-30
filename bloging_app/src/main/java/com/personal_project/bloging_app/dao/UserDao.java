package com.personal_project.bloging_app.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personal_project.bloging_app.dto.User;
import com.personal_project.bloging_app.repo.UserRepo;

@Repository
public class UserDao {
	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);

	}

	public User findUserById(int id) {
		// TODO Auto-generated method stub
		User user = repo.findById(id).get();
//		if (repo.findById(id).isPresent()) {
		if(user!=null) {
			return repo.findById(id).get();
		} else {
			return null;
		}
	}

	public User deleteUser(int id) {
		// TODO Auto-generated method stub
		 if (repo.findById(id).isPresent()) {
			 User user = repo.findById(id).get();
			 repo.delete(user);
			 return user;
		}else {
			return null;
		}
	}

	public void  deleteAllUsers() {
		// TODO Auto-generated method stub
		 repo.deleteAll();
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
	 List<User> list = repo.findAll();
	 if (list.isEmpty()) {
		return null;
	}else {
		System.out.println(list);
		return list;
	}
	}

	

	public User userUpdate(int id, User user) {
		// TODO Auto-generated method stub
		User user1 = repo.findById(id).get();
		if (user1!=null) {
			user.setId(id);
			repo.save(user);
			return user;
		}else {
			return null;
		}
		
			
		}
		
	}


