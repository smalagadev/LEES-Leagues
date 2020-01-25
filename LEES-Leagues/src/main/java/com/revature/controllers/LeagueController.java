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

import com.revature.models.League;
import com.revature.service.LeagueService;

@Controller
public class LeagueController {

	@RequestMapping(value="/leagues", method=RequestMethod.GET)
	@ResponseBody
	public List<League> findAll(){
		return LeagueService.getAllLeagues();
	}

	@GetMapping(value="/leagues/{league_name}")
	@ResponseBody
	public ResponseEntity<League> findByleaguename(@PathVariable("league_name") String leagueName){
		League l = LeagueService.getByLeagueName(leagueName);
		if(l == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(l);
	}

	@GetMapping(value="/leagues/{league_id}")
	@ResponseBody
	public ResponseEntity<League> getByleagueId(@PathVariable("league_id") int id){
		League l = LeagueService.getByLeagueId(id);
		if(l == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(l);
	}

	@PostMapping(value="/leagues")
	@ResponseBody
	public ResponseEntity<Boolean> save(@RequestBody League l){
		return ResponseEntity.ok(LeagueService.save(l));
	}

}
