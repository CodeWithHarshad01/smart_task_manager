package com.codewithharshad01.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithharshad01.entity.User;
import com.codewithharshad01.repo.UserRepo;
import com.codewithharshad01.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo repo;

	@Override
	public User saveUser(User user) {
		User saveUser = repo.save(user);
		return saveUser;
	}

	@Override
	public Optional<User> getUserById(long id) {
		return repo.findById(id);
	}

	@Override
	public Optional<User> updateUser(User user, long id) {
		User user2 = repo.findById(id).orElseThrow(()->new RuntimeException("user not found"));
		user2.setName(user.getName());
		user2.setEmail(user.getEmail());
		user2.setPassword(user.getPassword());
		user2.setRole(user.getRole());
		
		User save = repo.save(user2);
		return Optional.of(save);
		
	}

	@Override
	public List<User> getAllUser() {
		List<User> list = repo.findAll();
		return list;
	}

	@Override
	public void deleteUser(long id) {
		repo.deleteById(id);
		
	}

}
