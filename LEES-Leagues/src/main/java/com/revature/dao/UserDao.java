package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface UserDao {

	public User login(String username, String password);
	public User getByUsername(String username);
	public boolean save(User user);
	public boolean update(User user);
	public User getById(int id);
	public List<User> findAll();
}
