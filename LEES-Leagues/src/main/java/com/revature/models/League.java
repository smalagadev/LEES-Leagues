package com.revature.models;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
}
