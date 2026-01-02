package com.quickstay.hotelportal.dto;

import java.util.List;

public class RoomDTO {

    private String roomType;
    private double pricePerNight;
    private List<String> amenities;
    private boolean available;
    
  

	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public List<String> getAmenities() {
		return amenities;
	}
	public void setAmenities(List<String> amenities) {
		this.amenities = amenities;
	}
	public RoomDTO() {
		
	}
	public RoomDTO(String roomType, double pricePerNight, List<String> amenities, boolean available) {
		this.roomType = roomType;
		this.pricePerNight = pricePerNight;
		this.amenities = amenities;
		this.available = available;
	}
	

    
}
