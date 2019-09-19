package org.mano.otpdemo.controller;

import org.mano.otpdemo.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("otp")
public class OTPVerifyController {
	
	@Autowired
	OTPService service;
	
	@RequestMapping(value="/otpverify", method = RequestMethod.POST)
	public String verifyOTP(ModelMap model, HttpSession session, @RequestParam String otp){
		if(otp.equalsIgnoreCase(session.getAttribute("otp").toString())) {
			return "welcome";
		}else{
			model.put("errorMessage", "OTP Validation Failed !");
			return "login";
		}
	}

}
