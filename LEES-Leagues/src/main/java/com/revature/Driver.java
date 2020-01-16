package com.revature;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.models.User;

public class Driver {

	public static void main(String[] args) {

		initialValues();
		
	}
		
		public static void initialValues() {
			
			User u1 = new User("Lawrence", "Ross", "lmr608", "password", "lross@revature.com");
			User u2 = new User("Stefanno", "Malaga", "smalagadev", "password", "smalaga@revature.com");
			User u3 = new User("Elijah", "Jefferson", "jeffersone9", "password", "ejefferson@revature.com");
			User u4 = new User("Enrique", "Hunt", "mrhunt715", "password", "ehunt@revature.com");
			
			UserDao udao = new UserDaoImpl();
			udao.insert(u1);
			udao.insert(u2);
			udao.insert(u3);
			udao.insert(u4);
			
		}

}
