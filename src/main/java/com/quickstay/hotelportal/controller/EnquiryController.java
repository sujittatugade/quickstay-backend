package com.quickstay.hotelportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickstay.hotelportal.entity.Enquiry;
import com.quickstay.hotelportal.service.EnquiryService;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;
	
	
	@PostMapping("/add-enquiry")
	public void addEnquiry(@RequestBody Enquiry enquiry) {
		enquiryService.submitQuery(enquiry);
	}
	
	
}
