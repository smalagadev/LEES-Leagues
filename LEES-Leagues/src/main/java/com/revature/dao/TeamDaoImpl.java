package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Team;
import com.revature.util.ConnectionUtil;

public class TeamDaoImpl implements TeamDao {

	private static Logger logger = Logger.getLogger(TeamDaoImpl.class);
	
	@Override
	public List<Team> getAllTeams() {
		List<Team> allTeams = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM lees-leagues.team;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int i = 1;
			
			while(rs.next()) {
				int teamId = rs.getInt("team_id");
				String location = rs.getString("team_location");
				String name = rs.getString("team_name");
				
				Team team = new Team(teamId, location, name);
				allTeams.add(i, team);
				i++;
			}

		} catch (SQLException e) {
			logger.warn("Unable to get all Teams", e);
			e.printStackTrace();
		}
		return allTeams;
	}

	@Override
	public List<Team> getByTeamId(int id) {

		List<Team> Team = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM lees-leagues.team WHERE team_id = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			int i = 1;
			
			while(rs.next()) {
				int teamId = rs.getInt("team_id");
				String location = rs.getString("team_location");
				String name = rs.getString("team_name");
				
				Team team = new Team(teamId, location, name);
				Team.add(i, team);
				i++;
			}

		} catch (SQLException e) {
			logger.warn("Unable to get team from ID", e);
			e.printStackTrace();
		}
		return Team;
	}

	@Override
	public List<Team> getByUserId(int id) {
		
		List<Team> userTeams = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM lees-leagues.team WHERE user_id = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			int i = 1;
			
			while(rs.next()) {
				int teamId = rs.getInt("team_id");
				String location = rs.getString("team_location");
				String name = rs.getString("team_name");
				
				Team team = new Team(teamId, location, name);
				userTeams.add(i, team);
				i++;
			}

		} catch (SQLException e) {
			logger.warn("Unable to get Teams from User", e);
			e.printStackTrace();
		}
		return userTeams;
	
	}
	
}
