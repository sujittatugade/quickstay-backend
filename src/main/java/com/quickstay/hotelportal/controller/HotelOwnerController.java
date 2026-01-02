package com.quickstay.hotelportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickstay.hotelportal.entity.HotelOwner;
import com.quickstay.hotelportal.service.HotelOwnerServiceImplement;


@RestController
public class HotelOwnerController {
	
	@Autowired
	private HotelOwnerServiceImplement adminServiceImpl;
	
	
	@PostMapping("/addAdmin")
	public HotelOwner addAdmin(@RequestBody HotelOwner admin) {
		return adminServiceImpl.createAdmin(admin);
	}
	
	@PostMapping("/loginAdmin")
	public ResponseEntity<?> loginAdmin(@RequestBody HotelOwner admin) {
	HotelOwner found=adminServiceImpl.validateHotelOwner(admin.getEmail(),admin.getPassword());
		if(found !=null) {
			return ResponseEntity.ok(found);
		}
		else
			return ResponseEntity.status(401).body("Invalid Email or Password");
	}
	
	@PutMapping("/update-password")
	public HotelOwner updatePassword(@RequestBody HotelOwner hotelOwner) {
		return adminServiceImpl.updatePassHotelOwner( hotelOwner.getEmail(),
	            hotelOwner.getPassword());
	}
}
