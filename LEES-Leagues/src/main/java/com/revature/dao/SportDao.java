package com.revature.dao;

import java.util.List;

import com.revature.models.Sport;

public interface SportDao {

	public List<Sport> getAllSports();
	public Sport getBySportName(String sportName);
	public Sport getBySportId(int id);
	public boolean save(Sport sport);
	
}
