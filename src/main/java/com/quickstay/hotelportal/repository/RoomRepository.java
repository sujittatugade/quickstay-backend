package com.quickstay.hotelportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quickstay.hotelportal.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long>{

}
