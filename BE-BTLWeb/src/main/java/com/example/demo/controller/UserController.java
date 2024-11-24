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

import com.example.demo.model.Books;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getAllUser();
	}
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable String id, @RequestBody User user) {
		user.setId(Integer.valueOf(id));
		return userService.addUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(Integer.valueOf(id));
	}
}
