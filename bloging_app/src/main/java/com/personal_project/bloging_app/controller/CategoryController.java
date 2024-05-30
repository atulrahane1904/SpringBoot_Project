package com.personal_project.bloging_app.controller;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personal_project.bloging_app.dto.Catagory;
import com.personal_project.bloging_app.service.CategoryServiceImp;
import com.personal_project.bloging_app.util.ResponseStructure;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryServiceImp categoryService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Catagory>> saveCategory(@RequestBody Catagory category) {
		return categoryService.saveCategory(category);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Catagory>> updateCategory(@RequestParam  int id,@RequestBody  Catagory catagory) {
		return categoryService.updateCategory(id, catagory);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Catagory>> getCategory( @RequestParam int id) {
	    return categoryService.getCategory(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Catagory>> deleteCategory( @RequestParam int id) {
	    return categoryService.deleteCategory(id);
	}
@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Catagory>>> getAllCategory() {
		return categoryService.getAllCategory();
	}
}
