package com.revature.dao;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;

@Repository
public class UserDaoImpl implements UserDao {

	private static Logger logger = LogManager.getLogger(UserDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User login(String username, String password) {
		User user = getByUsername(username);
		if(user == null) {
			return null;
		}
		
		if(!user.getPassword().equals(password)) {
			return null;
		}
		return user;
	}


	@Override
	@Transactional
	public User getByUsername(String username) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get("username"), username));
		Query<User> q = s.createQuery(query);
		return q.getSingleResult();
	}

	@Override
	@Transactional
	public boolean save(User user) {
//		try(Session s = sessionFactory.getCurrentSession())
//		{
//			s.save(user);
//			return true;
//			
//		}catch(NullPointerException e) {
//			e.printStackTrace();
//			logger.warn("could not get session", e);
//			return false;
//		}
		Session s = sessionFactory.getCurrentSession();
		s.save(user);
		return true;

	}

	
	@Override
	@Transactional
	public User getById(int id) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get("user_id"), id));
		Query<User> q = s.createQuery(query);
		return q.getSingleResult();
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<User> findAll() {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root);
		Query<User> q = s.createQuery(query);
		return q.getResultList();
	}

	
	@Override
	@Transactional
	public boolean update(User user) {
		Session s = sessionFactory.getCurrentSession();
		s.update(user);
		return true;
	}

	@Override
	public boolean delete(User u) {
		Session s = sessionFactory.getCurrentSession();
		s.delete(u);
		return true;
	} 
	
}
