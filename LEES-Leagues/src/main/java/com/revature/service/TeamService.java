package com.revature.service;

import java.util.List;

import com.revature.dao.TeamDao;
import com.revature.dao.TeamDaoImpl;
import com.revature.models.Team;

public class TeamService {

	private static TeamDao tdao = new TeamDaoImpl();

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
