package com.quickstay.hotelportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickstay.hotelportal.entity.RoomImage;
import com.quickstay.hotelportal.repository.RoomImageRepository;
import com.quickstay.hotelportal.repository.RoomRepository;

@Service
public class RoomImageServiceImpl implements RoomImageService{
	
	@Autowired
	private RoomImageRepository roomImgRepo;
	
	@Override
	public void deleteImage(Long id) {
		
		roomImgRepo.deleteById(id);
	}

}
