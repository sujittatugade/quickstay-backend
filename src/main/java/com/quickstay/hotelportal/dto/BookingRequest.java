package com.quickstay.hotelportal.dto;

import java.sql.Date;

public class BookingRequest {

    private Long userId;
    private Long roomId;
	private Date checkIn;
    private Date checkOut;
    private String status;
    private Integer noOfPeople;

    public Integer getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(Integer noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
 
    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
