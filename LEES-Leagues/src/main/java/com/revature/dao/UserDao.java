package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface UserDao {

	public List<User> findAll();
	public User login(String Username, String password);
	public User getByUsername(String username);
	public User getById(int id);
	public void save(User user);
	public void update(User user);
	
}
