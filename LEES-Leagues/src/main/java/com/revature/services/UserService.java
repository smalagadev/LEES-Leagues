package com.revature.services;

import java.util.List;

import com.revature.dao.UserDaoImpl;
import com.revature.models.User;

public class UserService {

	public static List<User> findAll(){
		return new UserDaoImpl().findAll();
	}
	
	public static User findById(int id) {
		return new UserDaoImpl().findById(id);
	}
	
	public static User getByusername(String username) {
		return new UserDaoImpl().getByusername(username);
	}
	
	public static boolean update(User user) {
		return new UserDaoImpl().update(user);
	}
	
	public static boolean insert(User user) {
		return new UserDaoImpl().update(user);
	}
	
	public static User login(String username, String password) {
		return new UserDaoImpl().login(username, password);
	}
}
