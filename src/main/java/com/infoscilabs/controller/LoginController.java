package com.infoscilabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.infoscilabs.service.UserValidationService;

@Controller
@SessionAttributes("userId")
public class LoginController {
	
	
	@Autowired
	UserValidationService service;
	
	@RequestMapping(value="/login" ,method = RequestMethod.GET)
	//@ResponseBody
	public String showLoginPage( ModelMap model) {
		model.put("errorMessage", ""); 
		return "login";
	}
	
	@RequestMapping(value="/login" ,method = RequestMethod.POST)
	public String submitLogin(@RequestParam String userId , @RequestParam String password , ModelMap model) {
		if(service.isUserValid(userId, password)) {
			model.put("userId", userId);
			return "welcome";
		}else {
			model.put("errorMessage", "Invalid Credentials, Please check and resubmit"); 
			return "login";
		}
	}	
	
}
