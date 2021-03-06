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
public class WelcomeController extends BaseController{
	
	@RequestMapping(value="/" ,method = RequestMethod.GET)
	public String showLoginPage( ModelMap model) {
		model.put("userId", retrieveLoggedInUserId(model));
		return "welcome";
	}
	

	
}
