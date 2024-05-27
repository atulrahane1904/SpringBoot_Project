package com.personal_projet.spring_bloging_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personal_projet.spring_bloging_app.dto.User;
import com.personal_projet.spring_bloging_app.repo.UserRepo;
@Repository
public class UserDao {
@Autowired
private UserRepo userrepo;
	
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userrepo.save(user);
	}

	public User userUpdate(int id, User user) {
		// TODO Auto-generated method stub
		
		  return userrepo.save(user);
		
	}

	public User findUser(int id) {
		// TODO Auto-generated method stub
		return userrepo.findById(id).get();
	}


	public User findUser(String userId) {
		// TODO Auto-generated method stub
		try {
			   long phone= Long.parseLong(userId);
			   return userrepo.findByPhone(phone);
		} catch (Exception e) {
			// TODO: handle exception
			String email=userId;
			return userrepo.findByEmail(email);
		}

}
	}
