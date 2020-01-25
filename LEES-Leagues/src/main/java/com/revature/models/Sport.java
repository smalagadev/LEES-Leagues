package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

	public Sport() {
		super();
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

	@Override
	public int hashCode() {
		return Objects.hash(sportId, sportName);
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
		return sportId == other.sportId && Objects.equals(sportName, other.sportName);
	}

	@Override
	public String toString() {
		return "Sport [sportId=" + sportId + ", sportName=" + sportName + "]";
	}
	
}
