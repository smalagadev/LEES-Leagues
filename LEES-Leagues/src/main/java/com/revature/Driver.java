package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.UserDaoImpl;
import com.revature.models.User;

public class Driver {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserDaoImpl dao = (UserDaoImpl) ac.getBean("userDao");
				
		dao.save(new User("Lawrence", "Ross", "lmr608", "password", "lross@revature.com"));
		dao.save(new User("Stefanno", "Malaga", "smalagadev", "password", "smalaga@revature.com"));
		dao.save(new User("Elijah", "Jefferson", "jeffersone9", "password", "ejefferson@revature.com"));
		dao.save(new User("Enrique", "Hunt", "mrhunt715", "password", "ehunt@revature.com"));
	
		System.out.println(dao.getByUsername("lmr608"));
	}

}
