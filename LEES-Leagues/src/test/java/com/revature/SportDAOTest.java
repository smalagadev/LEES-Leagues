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
	public void testMockCreation() {
		assertNotNull(service);
		assertNotNull(dao);
		assertNotNull(sport);
	}
	
	@Test
	public void testGetAllSports() {
	List<Sport> list = new ArrayList<>();
	list.add(new Sport(1, "Basketball"));
	list.add(new Sport(2, "Football"));
	when(dao.getAllSports()).thenReturn(list); 
	List<Sport> result = SportService.getAllSports();
	verify(dao).getAllSports();
	assertNotNull(result);
	assertFalse(result.isEmpty());
	}
	
	@Test
	public void testGetBySportName() {
		Sport s = new Sport(1, "Basketball");
		when(dao.getBySportName("Basketball")).thenReturn(s);
		Sport result = SportService.getBySportName("Basketball");
		verify(dao).getBySportName("Basketball");
		assertNotNull(result);
	}
	
	@Test
	public void testGetBySportId() {
		Sport s = new Sport(1, "Basketball");
		when(dao.getBySportId(1)).thenReturn(s);
		Sport result = SportService.getBySportId(1);
		verify(dao).getBySportId(1);
		assertNotNull(result);
	}
	
	@Test
	public void testSave() {
		Sport newSport = new Sport(6, "Mixed Martial Arts");
        when(dao.save(newSport)).thenReturn(true);
        boolean result = SportService.save(newSport);
        verify(dao).save(newSport);
		assertNotNull(result);
	}

}
