package com.quickstay.hotelportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.quickstay.hotelportal.entity.HotelOwner;
import com.quickstay.hotelportal.repository.HotelOwnerRepository;

@Service
public class HotelOwnerServiceImplement  implements HotelOwnerService{
	
	@Autowired
	private HotelOwnerRepository adminRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public HotelOwner createAdmin(HotelOwner admin) {
		if(adminRepo.existsByEmail(admin.getEmail())) {
			throw new RuntimeException("Email already exists");
		}
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		return adminRepo.save(admin);
	}

	@Override
	public HotelOwner validateHotelOwner(String email, String password) {

	    HotelOwner owner = adminRepo.findByEmail(email)
	            .orElseThrow(() -> new RuntimeException("Invalid email or password"));

	    if (!passwordEncoder.matches(password, owner.getPassword())) {
	        throw new RuntimeException("Invalid email or password");
	    }

	    return owner;
	}

	@Override
	public HotelOwner updatePassHotelOwner(String email, String password) {

	    HotelOwner owner = adminRepo.findByEmail(email)
	            .orElseThrow(() ->
	                new RuntimeException("Hotel owner not found with email: " + email)
	            );

	    owner.setPassword(passwordEncoder.encode(password));

	    return adminRepo.save(owner);
	}

	

}
