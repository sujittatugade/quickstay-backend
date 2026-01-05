package com.quickstay.hotelportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quickstay.hotelportal.entity.HotelOwner;

@Repository
public interface HotelOwnerRepository extends JpaRepository<HotelOwner,Long> {
	Optional<HotelOwner> findByEmail(String email);
	boolean existsByEmail(String email);
}
