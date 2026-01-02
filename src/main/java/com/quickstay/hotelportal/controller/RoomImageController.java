package com.quickstay.hotelportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickstay.hotelportal.entity.RoomImage;
import com.quickstay.hotelportal.service.RoomImageService;

@RestController
@RequestMapping("/roomImage")
public class RoomImageController {

	@Autowired
	private RoomImageService roomImgService;
	
	
	@DeleteMapping("/deleteImage/{id}")
	public void deleteImage(@PathVariable Long id){
		roomImgService.deleteImage(id);
		
	}
	
}
