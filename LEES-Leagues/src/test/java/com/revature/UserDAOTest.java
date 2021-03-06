package com.revature;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.dao.UserDao;
import com.revature.models.User;
import com.revature.service.UserService;

public class UserDAOTest {

	private static UserService service;
	
	@Mock
	private static UserDao dao;
	
	@Mock
	private static User User;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		service = new UserService();
		service.setUserDao(dao);
	}
	
	@Test
	public void testMockCreation() {
		assertNotNull(service);
		assertNotNull(dao);
		assertNotNull(User);
	}
	
	@Test
	public void testfindAll() {
	List<User> list = new ArrayList<>();
	list.add(new User("Lawrence", "Ross", "lmr608", "password", "lross@revature.com"));
	list.add(new User("Stefanno", "Malaga", "smalagadev", "password", "smalaga@revature.com"));
	when(dao.findAll()).thenReturn(list); 
	List<User> result = UserService.findAll();
	verify(dao).findAll();
	assertNotNull(result);
	assertFalse(result.isEmpty());
	}
	
	@Test
	public void testGetByUserId() {
		User u = new User("Lawrence", "Ross", "lmr608", "password", "lross@revature.com");
		when(dao.getById(1)).thenReturn(u);
		User result = UserService.getById(1);
		verify(dao).getById(1);
		assertNotNull(result);
	}
	
	@Test
	public void testGetByUsername() {
		User u = new User("Lawrence", "Ross", "lmr608", "password", "lross@revature.com");
		when(dao.getByUsername("lmr608")).thenReturn(u);
		User result = UserService.getByUsername("lmr608");
		verify(dao).getByUsername("lmr608");
		assertNotNull(result);
	}
	
	//@Test
	public void testLogin() {
		
	}
	
	@Test
	public void testSave() {
		User newUser = new User("Elijah", "Jefferson", "jeffersone9", "password", "ejefferson@revature.com");
        when(dao.save(newUser)).thenReturn(true);
        boolean result = UserService.save(newUser);
        verify(dao).save(newUser);
		assertNotNull(result);
	}
	
	//@Test
	public void testUpdate() {
		
	}
	
	//@Test
	public void testDelete() {
		
	}

}
