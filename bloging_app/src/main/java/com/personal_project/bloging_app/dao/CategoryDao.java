package com.personal_project.bloging_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personal_project.bloging_app.dto.Catagory;
import com.personal_project.bloging_app.repo.CategoryRepo;

@Repository
public class CategoryDao {
	@Autowired
	private CategoryRepo categoryRepo;

	public Catagory saveCategory(Catagory catagory) {
		return categoryRepo.save(catagory);

		// TODO Auto-generated method stub

	}

	public Catagory updateCategory(int id, Catagory catagory) {
		// TODO Auto-generated method stub
	
//		Catagory catagory2 =categoryRepo.findById(id).get();
//		if (catagory2!= null) {
		if (categoryRepo.findById(id).isPresent()) {

			
			catagory.setId(id);
			categoryRepo.save(catagory);
			return catagory;
		} else {
		
			return null;
		}

	}

//	public Catagory findById(int id) {
//		// TODO Auto-generated method stub
//		Catagory catagory2 = categoryRepo.findById(id);
//		if (catagory2 != null) {
//			return catagory2;
//			}else {
//				return null;
//			}
//	}
	public Catagory deleteCategory(int id) {
		// TODO Auto-generated method stub
//		Catagory catagory2 = categoryRepo.findById(id).get();
//		if (catagory2 != null) {
		if (categoryRepo.findById(id).isPresent()) {

			Catagory catagory = categoryRepo.findById(id).get();
			categoryRepo.delete(catagory);
			return catagory;
		} else {
			return null;
		}
	}

	public Catagory findCatagoryById(int id) {
		// TODO Auto-generated method stub
		if (categoryRepo.findById(id).isPresent()) {
			return categoryRepo.findById(id).get();
		} else {
			return null;
		}
	}

	public List<Catagory> getAllUsers() {
		// TODO Auto-generated method stub
		        List<Catagory> all = categoryRepo.findAll();
		if (all.isEmpty()) {
			return null;
		}else {
			return all;
		}
	}
	

}
