package com.quickstay.hotelportal.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

	@Entity
	public class Amenity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    @ManyToOne
	    @JoinColumn(name = "room_id")
	    @JsonBackReference
	    private Room room;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Room getRoom() {
			return room;
		}

		public void setRoom(Room room) {
			this.room = room;
		}

		public Amenity() {
			
		}
		public Amenity(Long id, String name, Room room) {
			this.id = id;
			this.name = name;
			this.room = room;
		}

	  
	}


