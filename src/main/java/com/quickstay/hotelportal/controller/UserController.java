package com.quickstay.hotelportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickstay.hotelportal.entity.User;
import com.quickstay.hotelportal.service.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userSerImpl;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userSerImpl.createUser(user.getFullName(),user.getEmail());
	}
	
}
