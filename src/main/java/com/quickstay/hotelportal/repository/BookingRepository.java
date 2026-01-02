package com.quickstay.hotelportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quickstay.hotelportal.entity.Booking;
import java.util.List;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	List<Booking> findByRoomId(Long id);
	List<Booking> findByUser_Id(Long userId);
}
