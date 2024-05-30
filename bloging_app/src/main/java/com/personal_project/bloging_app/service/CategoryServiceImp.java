package com.personal_project.bloging_app.service;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.personal_project.bloging_app.dao.CategoryDao;
import com.personal_project.bloging_app.dto.Catagory;
import com.personal_project.bloging_app.util.ResponseStructure;
import com.ty.springboot_hospital_app.service.exception.IdNotFoundException;
@Service
public class CategoryServiceImp implements CategoryService {
@Autowired
private CategoryDao categoryDao;

	@Override
	public ResponseEntity<ResponseStructure<Catagory>> saveCategory(Catagory catagory) {
		// TODO Auto-generated method stub

		ResponseStructure<Catagory> structure = new ResponseStructure<>();
     	structure.setMessage("Saves Data Succesfully");
		structure.setData(categoryDao.saveCategory(catagory));
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Catagory>>(structure, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<Catagory>> updateCategory(int id, Catagory catagory) {
		// TODO Auto-generated method stub\
		Catagory category2 = categoryDao.updateCategory(id,catagory);
		ResponseStructure<Catagory> structure=new ResponseStructure<>();
		if (category2!=null) {
			structure.setMessage("category Updated succesfully");
			structure.setData(category2);
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Catagory>>(structure,HttpStatus.OK);
		}else {
			throw new com.personal_project.bloging_app.exception.IdNotFoundException("Id not found for Person");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Catagory>> deleteCategory(int id) {
		// TODO Auto-generated method stub
		ResponseStructure<Catagory> structure=new ResponseStructure<>();
		    Catagory catagory = categoryDao.deleteCategory(id);
		    if (catagory!=null) {
		    	structure.setMessage("category Deleted succesfully");
				structure.setData(catagory);
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Catagory>>(structure,HttpStatus.OK);
			}else {
				throw new com.personal_project.bloging_app.exception.IdNotFoundException("Id not found for Category");
			}
		
		
	}

	@Override
	public ResponseEntity<ResponseStructure<Catagory>> getCategory(int id) {
		ResponseStructure<Catagory> structure=new ResponseStructure<>();
	    Catagory catagory = categoryDao.findCatagoryById(id);
	    System.out.println(catagory);
	    if (catagory!=null) {
	    	structure.setMessage("category Found succesfully");
			structure.setData(catagory);
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Catagory>>(structure,HttpStatus.OK);
		}else {
			throw new com.personal_project.bloging_app.exception.IdNotFoundException("Id not found for Category");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List <Catagory>>> getAllCategory() {
		// TODO Auto-generated method stub
		List<Catagory> allUsers = categoryDao.getAllUsers();
		ResponseStructure< List<Catagory>> structure=new ResponseStructure<>();

		if (allUsers.isEmpty()) {
			throw new  com.personal_project.bloging_app.exception.IdNotFoundException("Id not found for Category");
		}else {
			
			structure.setMessage("categories Found Succesfully");
			structure.setData(allUsers);
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<  List<Catagory>>>(structure,HttpStatus.OK);
		}
	}

}
