package com.revature.dao;

import java.util.List;

import com.revature.models.Team;

public interface TeamDao {

	public List<Team> getAllTeams();
	public Team getByTeamName(String teamName);
	public Team getByTeamId(int id);
	public List<Team> getByUserId(int id);
	public boolean save(Team team);
	
}
