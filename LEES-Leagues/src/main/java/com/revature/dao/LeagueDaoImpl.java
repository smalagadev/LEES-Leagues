package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.League;

public class LeagueDaoImpl implements LeagueDao {

	@Autowired
	private SessionFactory sf;
	
	@SuppressWarnings({"deprecation", "unchecked"})
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<League> getAllLeagues() {
		
		Session s = sf.getCurrentSession();
		return (List<League>) s.createCriteria(League.class).list();
	}

	@Override
	public League getByLeagueId(int id) {
		Session s = sf.getCurrentSession();
		return s.get(League.class, id);
	}

	@Override
	public void save(League league) {
		Session s = sf.getCurrentSession();
		s.save(league);
	}

}
