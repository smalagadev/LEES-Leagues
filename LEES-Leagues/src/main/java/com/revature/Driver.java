package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.LeagueDaoImpl;
import com.revature.dao.SportDaoImpl;
import com.revature.dao.TeamDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.models.League;
import com.revature.models.Sport;
import com.revature.models.Team;
import com.revature.models.User;

public class Driver {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserDaoImpl udao = (UserDaoImpl) ac.getBean("userDao");
				
		udao.save(new User("Lawrence", "Ross", "lmr608", "password", "lross@revature.com"));
		udao.save(new User("Stefanno", "Malaga", "smalagadev", "password", "smalaga@revature.com"));
		udao.save(new User("Elijah", "Jefferson", "jeffersone9", "password", "ejefferson@revature.com"));
		udao.save(new User("Enrique", "Hunt", "mrhunt715", "password", "ehunt@revature.com"));
	
		System.out.println(udao.getByUsername("lmr608"));
		
		TeamDaoImpl tdao = (TeamDaoImpl) ac.getBean("teamDao");
		
		tdao.save(new Team(1, "Atlanta", "Hawks", null));
		tdao.save(new Team(2, "Boston", "Celtics", null));
		tdao.save(new Team(3, "Brooklyn", "Nets", null));
		tdao.save(new Team(4, "Charlotte", "Hornets", null));
		tdao.save(new Team(5, "Chicago", "Bulls", null));
		tdao.save(new Team(6, "Cleveland", "Cavaliers", null));
		tdao.save(new Team(7, "Dallas", "Mavericks", null));
		tdao.save(new Team(8, "Denver", "Nuggets", null));
		tdao.save(new Team(9, "Detroit", "Pistons", null));
		tdao.save(new Team(10, "Golden State", "Warriors", null));
		tdao.save(new Team(11, "Houston", "Rockets", null));
		tdao.save(new Team(12, "Indiana", "Pacers", null));
		tdao.save(new Team(13, "Los Angeles", "Clippers", null));
		tdao.save(new Team(14, "Los Angeles", "Lakers", null));
		tdao.save(new Team(15, "Memphis", "Grizzlies", null));
		tdao.save(new Team(16, "Miami", "Heat", null));
		tdao.save(new Team(17, "Milwaukee", "Bucks", null));
		tdao.save(new Team(18, "Minnesota", "Timberwolves", null));
		tdao.save(new Team(19, "New Orleans", "Pelicans", null));
		tdao.save(new Team(20, "New York", "Knicks", null));
		tdao.save(new Team(21, "Oklahoma City", "Thunder", null));
		tdao.save(new Team(22, "Orlando", "Magic", null));
		tdao.save(new Team(23, "Philadelphia", "76ers", null));
		tdao.save(new Team(24, "Phoenix", "Suns", null));
		tdao.save(new Team(25, "Portland", "Trailblazers", null));
		tdao.save(new Team(26, "Sacramento", "Kings", null));
		tdao.save(new Team(27, "San Antonio", "Spurs", null));
		tdao.save(new Team(28, "Toronto", "Raptors", null));
		tdao.save(new Team(29, "Utah", "Jazz", null));
		tdao.save(new Team(30, "Washington", "Wizards", null));
		
		System.out.println(tdao.getByTeamId(1));
		
		LeagueDaoImpl ldao = (LeagueDaoImpl) ac.getBean("leagueDao");
		
		ldao.save(new League("National Basketball League", 1));
		ldao.save(new League("National Football League", 2));
		ldao.save(new League("Major League Baseball", 3));
		ldao.save(new League("National Hockey League", 4));
		ldao.save(new League("Major League Soccer", 5));
		
		SportDaoImpl sdao = (SportDaoImpl) ac.getBean("sportDao");
		
		sdao.save(new Sport(1, "Basketball"));
		sdao.save(new Sport(2, "Football"));
		sdao.save(new Sport(3, "Baseball"));
		sdao.save(new Sport(4, "Hockey"));
		sdao.save(new Sport(5, "Soccer"));
		
		((AbstractApplicationContext) ac).close();

	}

}
