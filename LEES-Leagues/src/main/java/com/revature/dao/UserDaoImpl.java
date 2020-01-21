package com.revature.dao;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	private SessionFactory sf;

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
		Session s = sf.getCurrentSession();
		Transaction transaction = s.beginTransaction();
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get("username"), username));
		Query<User> q = s.createQuery(query);
		transaction.commit();
		return q.getSingleResult();
	}

	@Override
	@Transactional
	public boolean save(User user) {
		try(Session s = sf.getCurrentSession())
		{
			Transaction transaction = s.beginTransaction();
			s.save(user);
			transaction.commit();	
			return true;
			
		}catch(NullPointerException e) {
			logger.warn("could not get session", e);
			return false;
		}
	}

	
	@Override
	@Transactional
	public User getById(int id) {
		Session s = sf.getCurrentSession();
		Transaction transaction = s.beginTransaction();
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get("user_id"), id));
		Query<User> q = s.createQuery(query);
		transaction.commit();
		return q.getSingleResult();
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<User> findAll() {
		Session s = sf.getCurrentSession();
		Transaction transaction  = s.beginTransaction();
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root);
		Query<User> q = s.createQuery(query);
		transaction.commit();
		return q.getResultList();
	}

	
	@Override
	@Transactional
	public boolean update(User user) {
		Session s = sf.getCurrentSession();
		Transaction transaction = s.beginTransaction();
		s.update(user);
		transaction.commit();
		return true;
	}

	@Override
	public boolean delete(User u) {
		Session s = sf.getCurrentSession();
		s.delete(u);
		return true;
	} 
	
}
