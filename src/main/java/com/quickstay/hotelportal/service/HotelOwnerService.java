package com.quickstay.hotelportal.service;

import java.util.List;

import com.quickstay.hotelportal.entity.HotelOwner;

public interface HotelOwnerService  {

	public HotelOwner createAdmin(HotelOwner admin);
	public HotelOwner validateHotelOwner(String email,String password);
	public HotelOwner updatePassHotelOwner(String email,String password);
}
