package com.codewithharshad01.service;

import java.util.List;
import java.util.Optional;


import com.codewithharshad01.entity.User;

public interface UserService {
	public User saveUser(User user);

	public User getUserById(long id);

	public Optional<User> updateUser(User user, long id);

	public List<User> getAllUser();

	public void deleteUser(long id);

}
