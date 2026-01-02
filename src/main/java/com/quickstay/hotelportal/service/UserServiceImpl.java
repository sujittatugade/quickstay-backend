package com.quickstay.hotelportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickstay.hotelportal.entity.User;
import com.quickstay.hotelportal.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User createUser(String name, String email) {

	    return userRepo.findByEmail(email)
	            .map(existingUser -> {
	                if (!existingUser.getFullName().equals(name)) {
	                    existingUser.setFullName(name);
	                    return userRepo.save(existingUser);
	                }
	                return existingUser;
	            })
	            .orElseGet(() -> {
	    
	                User user = new User();
	                user.setFullName(name);
	                user.setEmail(email);
	                return userRepo.save(user);
	            });
	}



}
