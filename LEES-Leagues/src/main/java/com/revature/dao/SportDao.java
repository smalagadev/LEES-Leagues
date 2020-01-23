package com.revature.dao;

import java.util.List;

import com.revature.models.Sport;

public interface SportDao {

	public List<Sport> getAllSports();
	public Sport getBySportId(int id);
	public void save(Sport sport);
	
}
