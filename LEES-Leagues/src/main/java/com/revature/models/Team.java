package com.revature.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Team")
@Component
public class Team implements Serializable {

	private static final long serialVersionUID = -8461232721724337259L;

	@Id
	@Column(name="team_id", nullable=false, unique=true)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int teamId;

	@Column(name="team_location", nullable=false)
	private String location;

	@Column(name="team_name", nullable=false, unique=true)
	private String name;
	
	@Column
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<User> users;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="league_fk")
	private League leagueHolder;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="sport_fk")
	private Sport sportHolder;

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
	
	public Team(int teamId, String location, String name, List<User> users) {
		super();
		this.teamId = teamId;
		this.location = location;
		this.name = name;
		this.users = users;
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
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		return Objects.hash(location, name, teamId, users);
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
		return Objects.equals(location, other.location) && Objects.equals(name, other.name) && teamId == other.teamId
				&& Objects.equals(users, other.users);
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", location=" + location + ", name=" + name + ", users=" + users + "]";
	}

}
