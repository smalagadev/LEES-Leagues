package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Sport implements Serializable {

	private static final long serialVersionUID = -100429540491249344L;

	@Id
	@Column(name="sport_id", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sportId;

	@Column(name="sport_name", nullable=false)
	private String sportName;
}
