package com.revature.dao;

import java.util.List;

import com.revature.models.Team;
import com.revature.models.User;

public interface TeamDao {

	public List<Team> getAllTeams();
	public List<Team> getByTeamId(int id);
	public List<Team> getByUserId(int id);
	public void save(Team team);
	
}
