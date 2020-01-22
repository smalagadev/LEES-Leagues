package com.revature.service;

import java.util.List;

import com.revature.dao.TeamDao;
import com.revature.dao.TeamDaoImpl;
import com.revature.models.Team;

public class TeamService {

	private TeamDao tdao = new TeamDaoImpl();

	public TeamService() {
		
	}
	
	public List<Team> getAllTeams() {
		return tdao.getAllTeams();

	}
	
	public Team getByTeamId(int id) {
		return tdao.getByTeamId(id);
	}
	
	public List<Team> getByUserId(int id) {
		return tdao.getByUserId(id);
	}
	
	public void save(Team team) {
		
	}
	
	public void setTeamDao(TeamDao tdao) {
		this.tdao = tdao;
	}
	
}
