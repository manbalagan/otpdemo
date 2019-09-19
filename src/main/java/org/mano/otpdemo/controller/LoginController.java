package org.mano.otpdemo.controller;

import org.apache.http.HttpEntity;
import org.mano.otpdemo.service.LoginService;
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
@SessionAttributes("name")
public class LoginController {


	@Autowired
    LoginService service;

	@Autowired
	OTPService otpService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model){
		return "login";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String showLoginPage(HttpSession session){
		session.removeAttribute("otp");
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password, HttpSession session){
		
		boolean isValidUser = service.validateUser(name, password);


		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}else{
			session.setAttribute("otp", otpService.generateAndsendOTP());
		}
		
		model.put("name", name);
		model.put("password", password);

		
		return "/otpverify";
	}

}
