package com.revature;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.dao.LeagueDao;
import com.revature.models.League;
import com.revature.service.LeagueService;

public class LeagueDAOTest {

	private static LeagueService service;
	
	@Mock
	private static LeagueDao dao;
	
	@Mock
	private static League league;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		service = new LeagueService();
		service.setLeagueDao(dao);
	}
	
	@Test
	public void testMockCreation() {
		assertNotNull(service);
		assertNotNull(dao);
		assertNotNull(league);
	}
	
	@Test
	public void testGetAllLeagues() {
	List<League> list = new ArrayList<>();
	list.add(new League(1, "National Basketball League"));
	list.add(new League(2, "National Football League"));
	when(dao.getAllLeagues()).thenReturn(list); 
	List<League> result = LeagueService.getAllLeagues();
	verify(dao).getAllLeagues();
	assertNotNull(result);
	assertFalse(result.isEmpty());
	}
	
	@Test
	public void testGetByLeagueName() {
		League l = new League(1, "National Basketball League");
		when(dao.getByLeagueName("National Basketball League")).thenReturn(l);
		League result = LeagueService.getByLeagueName("National Basketball League");
		verify(dao).getByLeagueName("National Basketball League");
		assertNotNull(result);
	}
	
	@Test
	public void testGetByLeagueId() {
		League l = new League(1, "National Basketball League");
		when(dao.getByLeagueId(1)).thenReturn(l);
		League result = LeagueService.getByLeagueId(1);
		verify(dao).getByLeagueId(1);
		assertNotNull(result);
	}
	
	@Test
	public void testSave() {
		League newLeague = new League(6, "Ultimate Fighting Championship");
        when(dao.save(newLeague)).thenReturn(true);
        boolean result = LeagueService.save(newLeague);
        verify(dao).save(newLeague);
		assertNotNull(result);
	}

}
