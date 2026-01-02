package com.quickstay.hotelportal.service;

import com.quickstay.hotelportal.entity.User;

public interface UserService {
	User createUser(String name,String email);
}
