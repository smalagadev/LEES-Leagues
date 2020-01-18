package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;

import com.revature.models.Team;
import com.revature.models.User;

public class TeamDaoImpl implements TeamDao {
	
	@Autowired
	private SessionFactory sf;
	
	@SuppressWarnings({"deprecation", "unchecked"})
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Team> getAllTeams() {
		
		Session s = sf.getCurrentSession();
		return (List<Team>) s.createCriteria(Team.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Team> getByTeamId(int id) {
		Session s = sf.getCurrentSession();
		return (List<Team>) s.get(Team.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Team> getByUserId(int id) {
		Session s = sf.getCurrentSession();
		return (List<Team>) s.get(User.class, id);
	}
	
	@Override
	@Transactional
	public void save(Team t) {
		Session s = sf.getCurrentSession();
		s.save(t);
	}
	
}