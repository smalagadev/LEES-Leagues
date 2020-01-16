package com.revature.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	private static Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	@Override
	public User login(String username, String password) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM project1.users WHERE username = ? AND password = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int uid = rs.getInt("user_id");
				String ufirst_name = rs.getString("first_name");
				String ulast_name = rs.getString("last_name");
				String uusername = rs.getString("username");
				String upassword = rs.getString("password");
				String uemail = rs.getString("email");
				Array uteam_id = rs.getArray("team_id");
				
				User u = new User(uid, ufirst_name, ulast_name, uusername, upassword, uemail, uteam_id);
				return u;
			}
			rs.close();
		} catch (SQLException e) {
			logger.warn("Unable to get User from database", e);
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public User getByusername(String username) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM project1.users WHERE username = ? AND password = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int uid = rs.getInt("user_id");
				String ufirst_name = rs.getString("first_name");
				String ulast_name = rs.getString("last_name");
				String uusername = rs.getString("username");
				String upassword = rs.getString("password");
				String uemail = rs.getString("email");
				Array uteam_id = rs.getArray("team_id");
				
				User u = new User(uid, ufirst_name, ulast_name, uusername, upassword, uemail, uteam_id);
				return u;
			}
			rs.close();
		} catch (SQLException e) {
			logger.warn("Unable to get User from database", e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(User user) {

		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(user);
		tx.commit();
		ses.close();
		
	}

}
