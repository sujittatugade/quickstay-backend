package com.quickstay.hotelportal.controller;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.quickstay.hotelportal.dto.RoomDTO;
import com.quickstay.hotelportal.entity.Room;
import com.quickstay.hotelportal.service.RoomService;

@RestController
	@RequestMapping("/rooms")
	public class RoomController {

	    @Autowired
	    private RoomService roomService;

	    @PostMapping(value = "/add")
	    public Room addRoom(
	            @RequestParam("roomType") String roomType,
	            @RequestParam("price") double price,
	            @RequestParam(value = "amenities", required = false) List<String> amenities,
	            @RequestParam("images") List<MultipartFile> images
	    ) throws Exception {

	        RoomDTO dto = new RoomDTO();
	        dto.setRoomType(roomType);
	        dto.setPricePerNight(price);
	        dto.setAmenities(amenities);

	        return roomService.addRoom(dto, images);
	    }

	    @GetMapping("/all")
	    public List<Room> getAllRooms() {
	        return roomService.getAllRooms();
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
	    	 return ResponseEntity.ok(roomService.getRoomById(id));
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteRoom(@PathVariable Long id){
	    	roomService.deleteRoomById(id);
	    	return ResponseEntity.ok("Room Deleted Successfully");
	    }
	    
	    @PutMapping(value = "/update/{id}", consumes = "multipart/form-data")
	    public Room updateRooms(
	        @PathVariable Long id,
	        @RequestParam("roomType") String roomType,
	        @RequestParam("price") double price,
	        @RequestParam(value = "amenities", required = false) List<String> amenities,
	        @RequestParam(value = "images", required = false) List<MultipartFile> images
	    ) throws IOException {

	        RoomDTO roomdto = new RoomDTO();
	        roomdto.setRoomType(roomType);
	        roomdto.setPricePerNight(price);
	        roomdto.setAmenities(amenities);

	        return roomService.updateRoom(id, roomdto, images);
	    }

	    
	    @PutMapping("/availability/{id}")
	    public Room updateAvailability(@PathVariable Long id,@RequestParam boolean isAvailable) {
	    	
	    	return roomService.updateRoomAvailability(id, isAvailable);
	    	
	    }
	}


