package com.codewithharshad01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewithharshad01.entity.User;
import com.codewithharshad01.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	// Save User
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {
		User saveUser = service.saveUser(user);
		return saveUser;
	}

	// Get User By Id
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable long id) {
		User user = service.getUserById(id);
		return ResponseEntity.ok(user);
	}

	// Update User
	@PutMapping("/updateUser/{id}")
	public Optional<User> updateUser(@RequestBody User user, @PathVariable long id) {
		Optional<User> updateUser = service.updateUser(user, id);
		return updateUser;
	}

	// Get All User
	@GetMapping("/getAllUser")
	public List<User> getAllUser() {
		List<User> allUser = service.getAllUser();
		return allUser;
	}

	// Delete User by id
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable long id) {
		service.deleteUser(id);
		return ResponseEntity.ok("user deleted succesfully...");
		
	}
}
