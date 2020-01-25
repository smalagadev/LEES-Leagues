package com.revature.service;

import java.util.List;

import com.revature.dao.SportDao;
import com.revature.dao.SportDaoImpl;
import com.revature.models.Sport;

public class SportService {

	private static SportDao sdao = new SportDaoImpl();

	public SportService() {
		
	}
	
	public static List<Sport> getAllSports() {
		return sdao.getAllSports();
	}
	
	public static Sport getBySportId(int id) {
		return sdao.getBySportId(id);
	}
	
	public static void save(Sport sport) {
		
	}
	
	public void setSportDao(SportDao sdao) {
		SportService.sdao = sdao;
	}
	
}
