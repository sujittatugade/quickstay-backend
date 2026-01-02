package com.quickstay.hotelportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendPaymentConfirmation(
        String toEmail,
        String userName,
        String hotelName,
        String roomType,
        double price
    ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Payment Received - QuickStay");

        message.setText(
            "Hello " + userName + ",\n\n" +
            "Your payment has been successfully received.\n\n" +
            "Hotel: " + hotelName + "\n" +
            "Room Type: " + roomType + "\n" +
            "Amount Paid: ₹" + price + "\n\n" +
            "Thank you for booking with QuickStay!\n\n" +
            "Regards,\nQuickStay Team"
        );
        

        mailSender.send(message);
    }
    public void sendBookingConfirmation(String toEmail,String userName) {
    	SimpleMailMessage message= new SimpleMailMessage();
    	message.setTo(toEmail);
    	message.setSubject("Booking Confirmed Please Done Payment");
    	message.setText("Hello"+" "+userName+" " +"your booking is done.To proceed with payment "+"Thank you for booking with QuickStay!\n\n" +
                "Regards,\nQuickStay Team");
    	
    	mailSender.send(message);
    }
}

