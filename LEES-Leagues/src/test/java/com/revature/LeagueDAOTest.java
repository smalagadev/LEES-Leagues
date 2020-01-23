package com.revature;

import static org.junit.Assert.assertNotNull;

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
	public static void testMockCreation() {
		assertNotNull(service);
		assertNotNull(dao);
		assertNotNull(league);
	}
	
	

}
