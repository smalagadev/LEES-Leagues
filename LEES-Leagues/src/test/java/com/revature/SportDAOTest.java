package com.revature;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.dao.SportDao;
import com.revature.models.Sport;
import com.revature.service.SportService;

public class SportDAOTest {

	private static SportService service;
	
	@Mock
	private static SportDao dao;
	
	@Mock
	private static Sport sport;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		service = new SportService();
		service.setSportDao(dao);
	}
	
	@Test
	public static void testMockCreation() {
		assertNotNull(service);
		assertNotNull(dao);
		assertNotNull(sport);
	}
	
	

}
