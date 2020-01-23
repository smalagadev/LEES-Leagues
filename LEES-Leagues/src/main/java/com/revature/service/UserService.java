package com.revature.service;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.models.User;

public class UserService {
	
	private UserDao udao = new UserDaoImpl();
	
	public UserService() {
		
	}
	
	public List<User> findAll() {
		return udao.findAll();
	}
	
	public User getById(int id) {
		return udao.getById(id);
	}
	
	public User getByUsername(String username) {
		return udao.getByUsername(username);
	}
	
	public User login(String username, String password) {
		return udao.login(username, password);
	}
	
	public boolean save(User u) {
		return udao.save(u);
	}
	
	public boolean update(User u) {
		return udao.update(u);
	}
	
	public boolean delete(User u) {
		return udao.delete(u);
	}
	
	public void setUserDao(UserDao udao) {
		this.udao = udao;
	}

}
