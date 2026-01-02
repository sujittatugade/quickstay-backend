package com.quickstay.hotelportal.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickstay.hotelportal.entity.Booking;
import com.quickstay.hotelportal.entity.Room;
import com.quickstay.hotelportal.entity.User;
import com.quickstay.hotelportal.repository.BookingRepository;
import com.quickstay.hotelportal.repository.RoomRepository;
import com.quickstay.hotelportal.repository.UserRepository;
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private RoomRepository roomRepo;


    @Override
    public Booking createBooking(
            Long userId,
            Long roomId,
            Integer noOfPeople,
            Date checkIn,
            Date checkOut,
            String status
    ) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setRoomId(roomId);
        booking.setNoOfPeople(noOfPeople);  
        booking.setCheckIn(checkIn);
        booking.setCheckOut(checkOut);
        booking.setStatus("UNPAID");

        emailService.sendBookingConfirmation(
                booking.getUser().getEmail(),
                booking.getUser().getFullName()
        );

        return bookingRepo.save(booking);
    }

	@Override
	public List<Booking> getBookingsById(Long roomId) {
		
		return bookingRepo.findByRoomId(roomId);
	}
	
	@Override
	public List<Booking> getBookingsByUserId(Long userId) {
	    return bookingRepo.findByUser_Id(userId);
	}

	@Override
	public List<Booking> getAllBookings() {
		
		return bookingRepo.findAll();
	}

	  @Override
	    public Booking updateBookingStatus(Long bookingId, String status) {

	        Booking booking = bookingRepo.findById(bookingId)
	                .orElseThrow(() -> new RuntimeException("Booking not found"));

	        
	        if ("PAID".equalsIgnoreCase(booking.getStatus())) {
	            return booking;
	        }

	        booking.setStatus(status);
	        Booking savedBooking = bookingRepo.save(booking);

	        if ("PAID".equalsIgnoreCase(status)) {
	        	Room room=roomRepo.findById(booking.getRoomId()).orElseThrow(() -> new RuntimeException("Room not found"));
	            emailService.sendPaymentConfirmation(
	                    booking.getUser().getEmail(),
	                    booking.getUser().getFullName(),
	                    "QuickStay Hotel",
	                    room.getRoomType(),
	                    room.getPricePerNight()
	                   
	            );
	        }

	        return savedBooking;
	    }

	  @Override
	  public Booking cancelBooking(Long id) {
		 
		  Booking booking=bookingRepo.findById(id).orElseThrow(()-> new RuntimeException("Booking Not Found"));
		  
			 booking.setStatus("CANCELED");
			 return bookingRepo.save(booking);
		
	  }

	  @Override
	  public void deleteBooking(Long id) {
		bookingRepo.deleteById(id);
		
	  }

}
