package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface UserDao {

	public User login(String username, String password);
	public User getByusername(String username);
	public boolean insert(User user);
	public boolean update(User user);
	public User findById(int id);
	public List<User> findAll();
}
