package com.revature.dao;

import com.revature.models.User;

public interface UserDao {

	public User login(String username, String password);
	public User getByusername(String username);
	public void insert(User user);
	
}
