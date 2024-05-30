package com.personal_project.bloging_app.service;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.http.ResponseEntity;

import com.personal_project.bloging_app.dto.Catagory;
import com.personal_project.bloging_app.util.ResponseStructure;

public interface CategoryService {

	ResponseEntity<ResponseStructure<Catagory>> saveCategory(Catagory catagory);
	
	ResponseEntity<ResponseStructure<Catagory>> updateCategory(int id,Catagory catagory);
	
	ResponseEntity<ResponseStructure<Catagory>> deleteCategory(int id);
	
	ResponseEntity<ResponseStructure<Catagory>> getCategory (int id);
	
	ResponseEntity<ResponseStructure< List<Catagory>>> getAllCategory();
}
