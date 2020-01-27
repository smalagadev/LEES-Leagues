package com.revature.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Team;
import com.revature.models.User;

@Repository
public class TeamDaoImpl implements TeamDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Team> getAllTeams() {
		
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<Team> query = builder.createQuery(Team.class);
		Root<Team> root = query.from(Team.class);
		query.select(root);
		Query<Team> q = s.createQuery(query);
		return q.getResultList();
	}
	
	@Override
	public Team getByTeamName(String teamName) {
		Session s = sessionFactory.getCurrentSession();
		return s.get(Team.class, teamName);
	}

	@Override
	public Team getByTeamId(int id) {
		Session s = sessionFactory.getCurrentSession();
		return s.get(Team.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Team> getByUserId(int id) {
		Session s = sessionFactory.getCurrentSession();
		return (List<Team>) s.get(User.class, id);
	}
	
	@Override
	@Transactional
	public boolean save(Team t) {
		Session s = sessionFactory.getCurrentSession();
		s.save(t);
		return true;
	}
	
}
