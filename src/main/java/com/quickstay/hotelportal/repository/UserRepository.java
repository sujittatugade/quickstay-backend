package com.quickstay.hotelportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quickstay.hotelportal.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	
	Optional<User> findByEmail(String email);


}
