package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="League")
@Component
public class League implements Serializable {

	private static final long serialVersionUID = -4093820475112630048L;

	@Id
	@Column(name="league_id", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int leagueId;

	@Column(name="league_name", nullable=false)
	private String leagueName;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="sport_fk")
	private Sport sportHolder;

	public League() {
		super();
	}

	public League(int leagueId, String leagueName, Sport sportHolder) {
		super();
		this.leagueId = leagueId;
		this.leagueName = leagueName;
		this.sportHolder = sportHolder;
	}

	public League(int leagueId, String leagueName) {
		super();
		this.leagueId = leagueId;
		this.leagueName = leagueName;
	}

	public League(String leagueName, Sport sportHolder) {
		super();
		this.leagueName = leagueName;
		this.sportHolder = sportHolder;
	}

	public int getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public Sport getSportHolder() {
		return sportHolder;
	}

	public void setSportHolder(Sport sportHolder) {
		this.sportHolder = sportHolder;
	}

	@Override
	public int hashCode() {
		return Objects.hash(leagueId, leagueName, sportHolder);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof League)) {
			return false;
		}
		League other = (League) obj;
		return leagueId == other.leagueId && Objects.equals(leagueName, other.leagueName)
				&& Objects.equals(sportHolder, other.sportHolder);
	}

	@Override
	public String toString() {
		return "League [leagueId=" + leagueId + ", leagueName=" + leagueName + ", sportHolder=" + sportHolder + "]";
	}
	
}
