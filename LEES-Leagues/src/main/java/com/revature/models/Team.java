package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Team")
public class Team {

	@Column(name="team_id", nullable=false, unique=true)
	private int teamId;
	
	@Column(name="team_id", nullable=false)
	private String location;
	
	@Column(name="team_id", nullable=false, unique=true)
	private String name;

	public Team() {
		super();
	}

	public Team(String location, String name) {
		super();
		this.location = location;
		this.name = name;
	}

	public Team(int teamId, String location, String name) {
		super();
		this.teamId = teamId;
		this.location = location;
		this.name = name;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(location, name, teamId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Team)) {
			return false;
		}
		Team other = (Team) obj;
		return Objects.equals(location, other.location) && Objects.equals(name, other.name) && teamId == other.teamId;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", location=" + location + ", name=" + name + "]";
	}
	
}
