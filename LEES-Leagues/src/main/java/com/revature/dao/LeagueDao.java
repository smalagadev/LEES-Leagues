package com.revature.dao;

import java.util.List;

import com.revature.models.League;

public interface LeagueDao {

	public List<League> getAllLeagues();
	public League getByLeagueId(int id);
	public void save(League league);
	
}
