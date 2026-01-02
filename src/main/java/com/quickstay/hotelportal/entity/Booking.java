package com.quickstay.hotelportal.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;

	    @Column(name = "room_id")
	    private Long roomId;

	    @Column(name = "no_of_people", nullable = false)
	    private Integer noOfPeople;
	    
		@Column(name = "check_in")
	    private Date checkIn;

	    @Column(name = "check_out")
	    private Date checkOut;

	    private String status;
	    
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		
		public Integer getNoOfPeople() {
			return noOfPeople;
		}

		public void setNoOfPeople(Integer noOfPeople) {
			this.noOfPeople = noOfPeople;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
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
