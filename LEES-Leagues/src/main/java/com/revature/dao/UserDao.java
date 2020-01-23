package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface UserDao {

	public List<User> findAll();
	public User login(String username, String password);
	public User getByUsername(String username);
	public User getById(int id);
	public boolean save(User user);
	public boolean update(User user);
	public boolean delete(User user);
	public void logout();
}
