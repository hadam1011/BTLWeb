package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

@RestController
@CrossOrigin
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> getAllCategory() {
		return categoryService.getAll();
	}
	
	@PostMapping("/category")
	public Category createCategory(@RequestBody Category category) {
		return categoryService.save(category);
	}
	
	@PutMapping("/category/{id}")
	public Category updateCategory(@PathVariable String id, @RequestBody Category category) {
		category.setId(Integer.valueOf(id));
		return categoryService.save(category);
	}
	
	@DeleteMapping("/category/{id}")
	public void deleteCategory(@PathVariable String id) {
		categoryService.delete(Integer.valueOf(id));
	}
}
