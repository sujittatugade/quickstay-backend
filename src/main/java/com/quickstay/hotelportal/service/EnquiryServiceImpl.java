package com.quickstay.hotelportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickstay.hotelportal.entity.Enquiry;
import com.quickstay.hotelportal.repository.EnquiryRepository;

@Service
public class EnquiryServiceImpl  implements EnquiryService{

	@Autowired
	private EnquiryRepository enquiryRepository;
	
	@Override
	public void submitQuery(Enquiry enquiry){
		enquiryRepository.save(enquiry);
	}
	

}
