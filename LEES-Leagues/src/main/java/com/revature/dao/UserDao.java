package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface UserDao {

	public boolean login(String username, String password);
	public User getByusername(String username);
	public void insert(User user);
	public void update(User user);
	public User findById(int id);
	public List<User> findAll();
}
