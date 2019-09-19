package org.mano.otpdemo.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OTPService {


    public static final String ACCOUNT_SID = "SID FROM TWILIO ACCOUNT";
    public static final String AUTH_TOKEN  = "TOKEN FROM TWILIO ACCOUNT";
    public static final String TWILIO_NUMBER = "YOUR TWILIO PHONE NUMBER";// Sample : +14442226666

    public int generateAndsendOTP(){
        int randomOTP = 100000 + new Random().nextInt(900000);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new PhoneNumber("TO PHONE NUMBER"),  // Sample : +14442226666
                new PhoneNumber(TWILIO_NUMBER),
                randomOTP + " is your OTP. Please provide this on your login for secure login")
                .create();
        System.out.println("Message Sent :: " + message);
        return randomOTP;
    }
}
