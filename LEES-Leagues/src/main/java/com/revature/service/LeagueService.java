package com.revature.service;

import java.util.List;

import com.revature.dao.LeagueDao;
import com.revature.dao.LeagueDaoImpl;
import com.revature.models.League;

public class LeagueService {

	private static LeagueDao ldao = new LeagueDaoImpl();

	public LeagueService() {
		
	}
	
	public static List<League> getAllLeagues() {
		return ldao.getAllLeagues();
	}
	
	public static League getByLeagueName(String leagueName) {
		return ldao.getByLeagueName(leagueName);
	}
	
	public static League getByLeagueId(int id) {
		return ldao.getByLeagueId(id);
	}
	
	public static boolean save(League league) {
		return ldao.save(league);
	}
	
	public void setLeagueDao(LeagueDao ldao) {
		LeagueService.ldao = ldao;
	}
	
}
