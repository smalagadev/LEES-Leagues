package com.revature.dao;

import java.util.List;

import com.revature.models.League;

public interface LeagueDao {

	public List<League> getAllLeagues();
	public League getByLeagueName(String leagueName);
	public League getByLeagueId(int id);
	public boolean save(League league);
	
}
