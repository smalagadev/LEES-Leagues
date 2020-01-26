package com.revature.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Team;
import com.revature.service.TeamService;

@Controller
public class TeamController {

	@RequestMapping(value="/teams", method=RequestMethod.GET)
	@ResponseBody
	public List<Team> findAll(){
		return TeamService.getAllTeams();
	}
	
	@GetMapping(value="/teams/{teamname}")
	@ResponseBody
	public ResponseEntity<Team> findByteamname(@PathVariable("teamname") String teamName){
		Team t = TeamService.getByTeamName(teamName);
		if(t == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(t);
	}

	@GetMapping(value="/teams/{id}")
	@ResponseBody
	public ResponseEntity<Team> findById(@PathVariable("id") int id){
		Team t = TeamService.getByTeamId(id);
		if(t == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(t);
	}

	@PostMapping(value="/teams")
	@ResponseBody
	public ResponseEntity<Boolean> save(@RequestBody Team t){
		return ResponseEntity.ok(TeamService.save(t));
	}

}
