package com.quickstay.hotelportal.service;

import java.sql.Date;
import java.util.List;

import com.quickstay.hotelportal.entity.Booking;

public interface BookingService {
	Booking createBooking(
		    Long userId,
		    Long roomId,
		    Integer noOfPeople,
		    Date checkIn,
		    Date checkOut,
		    String status
		);

    List<Booking> getBookingsById(Long roomId);
    List<Booking> getAllBookings();
    List<Booking> getBookingsByUserId(Long userId);
    Booking updateBookingStatus(Long bookingId, String status);
    Booking cancelBooking(Long id);
    void deleteBooking(Long id);
    
}

