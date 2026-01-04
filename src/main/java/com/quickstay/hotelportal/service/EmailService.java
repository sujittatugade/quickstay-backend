package com.quickstay.hotelportal.service;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${RESEND_API_KEY}")
    private String resendApiKey;

    @Value("${MAIL_FROM:noreply@quickstay.com}")
    private String fromEmail;


    private static final String RESEND_URL = "https://api.resend.com/emails";

    private final OkHttpClient client = new OkHttpClient();


    public void sendPaymentConfirmation(
            String toEmail,
            String userName,
            String hotelName,
            String roomType,
            double price
    ) {
        String subject = "Payment Received - QuickStay";

        String html = """
            <p>Hello <b>%s</b>,</p>
            <p>Your payment has been <b>successfully received</b>.</p>
            <ul>
              <li><b>Hotel:</b> %s</li>
              <li><b>Room Type:</b> %s</li>
              <li><b>Amount Paid:</b> ₹%.2f</li>
            </ul>
            <p>Thank you for booking with <b>QuickStay</b>!</p>
            <br/>
            <p>Regards,<br/>QuickStay Team</p>
        """.formatted(userName, hotelName, roomType, price);

        sendEmail(toEmail, subject, html);
    }

    public void sendBookingConfirmation(String toEmail, String userName) {

        String subject = "Booking Confirmed – Complete Payment";

        String html = """
            <p>Hello <b>%s</b>,</p>
            <p>Your booking has been <b>successfully confirmed</b>.</p>
            <p>Please proceed with payment to finalize your reservation.</p>
            <br/>
            <p>Thank you for choosing <b>QuickStay</b>!</p>
            <br/>
            <p>Regards,<br/>QuickStay Team</p>
        """.formatted(userName);

        sendEmail(toEmail, subject, html);
    }


    private void sendEmail(String to, String subject, String html) {
        try {
            String json = """
                {
                  "from": "%s",
                  "to": ["%s"],
                  "subject": "%s",
                  "html": "%s"
                }
            """.formatted(fromEmail, to, subject, html);

            Request request = new Request.Builder()
                    .url(RESEND_URL)
                    .post(RequestBody.create(json, MediaType.parse("application/json")))
                    .addHeader("Authorization", "Bearer " + resendApiKey)
                    .build();

            client.newCall(request).execute();

        } catch (Exception e) {
            // IMPORTANT: Do not crash app if email fails
            System.err.println("Email failed: " + e.getMessage());
        }
    }
}
