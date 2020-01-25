package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Sport;

public class SportDaoImpl implements SportDao {

	@Autowired
	private SessionFactory sf;
	
	@SuppressWarnings({"deprecation", "unchecked"})
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Sport> getAllSports() {
		
		Session s = sf.getCurrentSession();
		return (List<Sport>) s.createCriteria(Sport.class).list();
	}

	@Override
	public Sport getBySportId(int id) {
		Session s = sf.getCurrentSession();
		return s.get(Sport.class, id);
	}

	@Override
	public void save(Sport sport) {
		Session s = sf.getCurrentSession();
		s.save(sport);
	}

}
