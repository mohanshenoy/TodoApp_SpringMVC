package com.infoscilabs.service;

import org.springframework.stereotype.Service;

@Service
public class UserValidationService {
	
	public boolean isUserValid(String userId , String password) {
		if(userId.equalsIgnoreCase("mohan") && password.equalsIgnoreCase("password")) {
			return true;
		}else {
			return false;
		}
	}
}
