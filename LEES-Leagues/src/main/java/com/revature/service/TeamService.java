package com.revature.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.revature.dao.TeamDao;
import com.revature.dao.TeamDaoImpl;
import com.revature.dao.UserDao;
import com.revature.models.Team;

@Service
public class TeamService {

	private static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	private static TeamDao tdao = (TeamDao) ac.getBean("teamDaoImpl");
	

	public TeamService() {
		
	}
	
	public static List<Team> getAllTeams() {
		return tdao.getAllTeams();

	}
	
	public static Team getByTeamName(String teamName) {
		return tdao.getByTeamName(teamName);
	}
	
	public static Team getByTeamId(int id) {
		return tdao.getByTeamId(id);
	}
	
	public static List<Team> getByUserId(int id) {
		return tdao.getByUserId(id);
	}
	
	public static boolean save(Team team) {
		return tdao.save(team);
	}
	
	public void setTeamDao(TeamDao tdao) {
		TeamService.tdao = tdao;
	}
	
}
