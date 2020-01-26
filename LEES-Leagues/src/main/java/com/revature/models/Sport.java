package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Sport")
@Component
public class Sport implements Serializable {

	private static final long serialVersionUID = -100429540491249344L;

	@Id
	@Column(name="sport_id", nullable=false, unique=true)
	private int sportId;

	@Column(name="sport_name", nullable=false)
	private String sportName;
	
	@OneToMany(mappedBy="sportHolder", fetch=FetchType.LAZY)
	private List<League> leagueList = new ArrayList<>();

	@OneToMany(mappedBy="sportHolder", fetch=FetchType.LAZY)
	private List<Team> teamList = new ArrayList<>();

	public Sport() {
		super();
	}
	
	public Sport(int sportId, String sportName, List<League> leagueList, List<Team> teamList) {
		super();
		this.sportId = sportId;
		this.sportName = sportName;
		this.leagueList = leagueList;
		this.teamList = teamList;
	}

	public Sport(int sportId, String sportName) {
		super();
		this.sportId = sportId;
		this.sportName = sportName;
	}

	public int getSportId() {
		return sportId;
	}

	public void setSportId(int sportId) {
		this.sportId = sportId;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	
	public List<League> getLeagueList() {
		return leagueList;
	}

	public void setLeagueList(List<League> leagueList) {
		this.leagueList = leagueList;
	}

	public List<Team> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(leagueList, sportId, sportName, teamList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Sport)) {
			return false;
		}
		Sport other = (Sport) obj;
		return Objects.equals(leagueList, other.leagueList) && sportId == other.sportId
				&& Objects.equals(sportName, other.sportName) && Objects.equals(teamList, other.teamList);
	}

	@Override
	public String toString() {
		return "Sport [sportId=" + sportId + ", sportName=" + sportName + ", leagueList=" + leagueList + ", teamList="
				+ teamList + "]";
	}
	
}
