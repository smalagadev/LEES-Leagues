package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import com.revature.models.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sf;
	
	@SuppressWarnings({"deprecation", "unchecked"})
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<User> findAll() {
		Session s = sf.getCurrentSession();
		return (List<User>) s.createCriteria(User.class).list();
	}
	
	@Override
	public User Login(String Username, String password) {
		return null;
	}
	
	@Override
	@Transactional
	public User getByUsername(String username) {
		Session s = sf.getCurrentSession();
		return s.get(User.class, username);
	}
	
	@Override
	@Transactional
	public User getById(int id) {
		Session s = sf.getCurrentSession();
		return s.get(User.class, id);
	}

	@Override
	@Transactional
	public void save(User u) {
		Session s = sf.getCurrentSession();
		s.save(u);
	}
	
	@Override
	@Transactional
	public void update(User u) {
		Session s = sf.getCurrentSession();
		s.update(u);
	}

}
