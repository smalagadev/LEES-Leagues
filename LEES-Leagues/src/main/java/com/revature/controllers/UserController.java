package com.revature.controllers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.User;
import com.revature.service.UserService;

@Controller
public class UserController {

	@RequestMapping(value="/users", method=RequestMethod.GET)
	@ResponseBody
	public List<User> findAll(){
		return UserService.findAll();
	}
	
	@GetMapping(value="/users/{id}")
	@ResponseBody
	public ResponseEntity<User> findById(@PathVariable("id") int id){
		User u = UserService.getById(id);
		if(u == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	
	@GetMapping(value="/users/{username}")
	@ResponseBody
	public ResponseEntity<User> findByusername(@PathVariable("username") String username){
		User u = UserService.getByUsername(username);
		if(u == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	
	@GetMapping(value="/users/login")
	@ResponseBody
	public ResponseEntity<User> login(@PathVariable("username") String username, @PathVariable("password") String password){
		User u = UserService.login(username, password);
		if(u == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	@PutMapping(value="/users")
	@ResponseBody
	public ResponseEntity<Boolean> update(@RequestBody User u){
		return ResponseEntity.ok(UserService.update(u));
	}
	
	@PostMapping(value="/users")
	@ResponseBody
	public ResponseEntity<Boolean> save(@RequestBody User u){
		return ResponseEntity.ok(UserService.save(u));
	}
	
}
