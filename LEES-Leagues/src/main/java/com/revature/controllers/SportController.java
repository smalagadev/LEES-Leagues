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

import com.revature.models.Sport;
import com.revature.service.SportService;

@Controller
public class SportController {

	@RequestMapping(value="/sports", method=RequestMethod.GET)
	@ResponseBody
	public List<Sport> findAll(){
		return SportService.getAllSports();
	}

	@GetMapping(value="/sports/{sport_name}")
	@ResponseBody
	public ResponseEntity<Sport> findBySportName(@PathVariable("sport_name") String sportName){
		Sport s = SportService.getBySportName(sportName);
		if(s == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(s);
	}

	@GetMapping(value="/sports/{sport_id}")
	@ResponseBody
	public ResponseEntity<Sport> getBySportId(@PathVariable("sport_id") int id){
		Sport s = SportService.getBySportId(id);
		if(s == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(s);
	}

	@PostMapping(value="/sports")
	@ResponseBody
	public ResponseEntity<Boolean> save(@RequestBody Sport s){
		return ResponseEntity.ok(SportService.save(s));
	}

}
