package com.quickstay.hotelportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quickstay.hotelportal.entity.HotelOwner;

@Repository
public interface HotelOwnerRepository extends JpaRepository<HotelOwner,Long> {
	HotelOwner findByEmailAndPassword(String email,String password);
	HotelOwner findByEmail(String email);
}
