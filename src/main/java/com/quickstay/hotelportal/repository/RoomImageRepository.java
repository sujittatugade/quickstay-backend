package com.quickstay.hotelportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quickstay.hotelportal.entity.RoomImage;

@Repository
public interface RoomImageRepository  extends JpaRepository<RoomImage,Long>{

}
