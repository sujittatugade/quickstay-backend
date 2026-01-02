package com.quickstay.hotelportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickstay.hotelportal.entity.HotelOwner;
import com.quickstay.hotelportal.repository.HotelOwnerRepository;

@Service
public class HotelOwnerServiceImplement  implements HotelOwnerService{
	
	@Autowired
	private HotelOwnerRepository adminRepo;
	
	@Override
	public HotelOwner createAdmin(HotelOwner admin) {
		return adminRepo.save(admin);
	}

	@Override
	public HotelOwner validateHotelOwner(String email, String password) {
		return adminRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public HotelOwner updatePassHotelOwner(String email, String password) {

	   
	    HotelOwner owner = adminRepo.findByEmail(email);

	    if (owner == null) {
	        throw new RuntimeException("Hotel owner not found with email: " + email);
	    }

	    owner.setPassword(password);

	    return adminRepo.save(owner);
	}


	

}
