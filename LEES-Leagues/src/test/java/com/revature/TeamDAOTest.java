package com.revature;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.dao.TeamDao;
import com.revature.models.Team;
import com.revature.service.TeamService;

public class TeamDAOTest {
	
	private TeamService service;
	
	@Mock
	private TeamDao dao;
	
	@Mock
	private Team team;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		service = new TeamService();
		service.setTeamDao(dao);
	}
	
	@Test
	public void testMockCreation() {
		assertNotNull(service);
		assertNotNull(dao);
		assertNotNull(team);
	}
	
	@Test
	public void testGetAllTeams() {
	List<Team> list = new ArrayList<>();
	list.add(new Team(1,"Atlanta","Hawks",null));
	list.add(new Team(2,"Boston","Celtics",null));
	 
	when(dao.getAllTeams()).thenReturn(list); 
	 
	List<Team> result = service.getAllTeams();
	 
	verify(dao).getAllTeams();
	
	assertNotNull(result);
	assertFalse(result.isEmpty());
	}
	
	@Test
	public void testGetByTeamId() {
		Team t = new Team(1, "Atlanta", "Hawks", null);
		when(dao.getByTeamId(1)).thenReturn(t);
		Team result = service.getByTeamId(1);
		verify(dao).getByTeamId(1);
		assertNotNull(result);
	}
	
	@Test
	public void testGetByUserId() {
		List<Team> list = new ArrayList<Team>();
		list.add(new Team(1, "Atlanta", "Hawks"));
		list.add(new Team(2, "Boston", "Celtics"));
		when(dao.getByUserId(1)).thenReturn(list);
		List<Team> result = service.getByUserId(1);
		verify(dao, atLeastOnce()).getByUserId(1);
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}
	
	//@Test
	public void testSave() {
		
	}

}
