package com.quickstay.hotelportal.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.quickstay.hotelportal.dto.RoomDTO;
import com.quickstay.hotelportal.entity.Amenity;
import com.quickstay.hotelportal.entity.Room;
import com.quickstay.hotelportal.entity.RoomImage;
import com.quickstay.hotelportal.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepo;

    @Override
    public Room addRoom(RoomDTO dto, List<MultipartFile> images) throws Exception {

        Room room = new Room();
        room.setRoomType(dto.getRoomType());
        room.setPricePerNight(dto.getPricePerNight());
        room.setAvailable(false); 

        // Amenities
        List<Amenity> amenityList = dto.getAmenities().stream().map(name -> {
            Amenity a = new Amenity();
            a.setName(name);
            a.setRoom(room);
            return a;
        }).toList();

      
        List<RoomImage> imageList = new ArrayList<>();
        for (MultipartFile file : images) {
            RoomImage img = new RoomImage();
            img.setImage(file.getBytes());
            img.setRoom(room);
            imageList.add(img);
        }

        room.setAmenities(amenityList);
        room.setImages(imageList);

        return roomRepo.save(room);
    }

	@Override
    public List<Room> getAllRooms() {
        return roomRepo.findAll(); 
    }

	@Override
	public void deleteRoomById(Long id) {
		
		if(!roomRepo.existsById(id)) {
			 throw new RuntimeException("Room not found with id: " + id);
		}
			roomRepo.deleteById(id);
	}

	@Override
	public Room updateRoom(Long id, RoomDTO dto, List<MultipartFile> images) throws IOException {

	    Room room = roomRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));

	    room.setRoomType(dto.getRoomType());
	    room.setPricePerNight(dto.getPricePerNight());

	    room.getAmenities().clear();

	    if (dto.getAmenities() != null) {
	        for (String name : dto.getAmenities()) {
	            if (name != null && !name.trim().isEmpty()) {
	                Amenity a = new Amenity();
	                a.setName(name);
	                a.setRoom(room);
	                room.getAmenities().add(a);
	            }
	        }
	    }


	    if (images != null && !images.isEmpty()) {
	        room.getImages().clear();
	        for (MultipartFile file : images) {
	            RoomImage ri = new RoomImage();
	            ri.setImage(file.getBytes());
	            ri.setRoom(room);
	            room.getImages().add(ri);
	        }
	    }

	    return roomRepo.save(room);
	}

	@Override
	public Room getRoomById(Long id) {
	    return roomRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));
	}

	@Override
	public Room updateRoomAvailability(Long id, boolean isAvailable) {
	    Room room = roomRepo.findById(id)
	        .orElseThrow(() -> new RuntimeException("Room not found"));

	    room.setAvailable(isAvailable);
	    return roomRepo.save(room);
	}

}

