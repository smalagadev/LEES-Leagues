package com.revature.service;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.models.User;

public class UserService {
	
	private static UserDao udao = new UserDaoImpl();
	
	public UserService() {
		
	}
	
	public static List<User> findAll() {
		return udao.findAll();
	}
	
	public static User getById(int id) {
		return udao.getById(id);
	}
	
	public static User getByUsername(String username) {
		return udao.getByUsername(username);
	}
	
	public static User login(String username, String password) {
		return udao.login(username, password);
	}
	
	public static boolean save(User u) {
		return udao.save(u);
	}
	
	public static boolean update(User u) {
		return udao.update(u);
	}
	
	public static boolean delete(User u) {
		return udao.delete(u);
	}
	
	public void setUserDao(UserDao udao) {
		UserService.udao = udao;
	}

}
