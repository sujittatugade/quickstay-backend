package com.quickstay.hotelportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quickstay.hotelportal.entity.Amenity;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Long> {

}
