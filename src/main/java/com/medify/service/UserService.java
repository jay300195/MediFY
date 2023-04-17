package com.medify.service;


import java.util.List;

import com.medify.entity.User;

public interface UserService {

	User saveUser(User user);
	
	List<User> fetchAllUsers();
	
	User getUserById(Long id);
	
	User updateUserById(Long id,User user);
	
	void deleteUserById(Long id);
}
