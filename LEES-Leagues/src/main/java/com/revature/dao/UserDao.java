package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface UserDao {

	public User login(String username, String password);
	public User getByUsername(String username);
	public boolean save(User user);
	public boolean update(User user);
	public User getById(int id);
<<<<<<< HEAD
	public void save(User user);
	public void update(User user);
	public boolean delete(User user);
	
=======
	public List<User> findAll();
>>>>>>> 1a7b487c6747c8a21a5d1cd3fd49f86a39273e1c
}
