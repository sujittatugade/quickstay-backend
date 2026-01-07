package com.quickstay.hotelportal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickstay.hotelportal.dto.BookingRequest;
import com.quickstay.hotelportal.entity.Booking;
import com.quickstay.hotelportal.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/add-booking")
    public ResponseEntity<Booking> addBooking(@RequestBody BookingRequest request) {

    	Booking booking = bookingService.createBooking(
    		    request.getUserId(),
    		    request.getRoomId(),
    		    request.getNoOfPeople(),   
    		    request.getCheckIn(),
    		    request.getCheckOut(),
    		    request.getStatus()
    		);
        return ResponseEntity.ok(booking);
    }
    
    @GetMapping("/get-dates/{roomId}")
    public ResponseEntity<?> getBookingDates(@PathVariable Long roomId){
		return ResponseEntity.ok(bookingService.getBookingsById(roomId));
    	
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(bookingService.getBookingsByUserId(userId));
    }
    
    @GetMapping("/allBookings")
    public List<Booking> getBookings(){
    	return bookingService.getAllBookings();
    }

    @PutMapping("/update-status/{id}")
    public ResponseEntity<Booking> updateStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> body
    ) {
        String newStatus = body.get("status");
        Booking updatedBooking = bookingService.updateBookingStatus(id, newStatus);
        return ResponseEntity.ok(updatedBooking);
    }

    
    @PutMapping("/cancel-booking/{id}")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long id){
    	Booking booking=bookingService.cancelBooking(id);
    	return ResponseEntity.ok(booking);
    }
    
    @DeleteMapping("/delete-booking/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id){
    	bookingService.deleteBooking(id);
    	return ResponseEntity.ok("Booking Deleted Sucessfully");
    }
}
