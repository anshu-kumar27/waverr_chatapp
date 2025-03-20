package com.app.service;

import com.app.dto.response.LoginResponse;
import com.app.dto.response.UserDetailsDto;
import com.app.dto.user.UserLogin;
import com.app.dto.user.UserRegistration;
import com.app.exception.CustomException;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
	
	LoginResponse registerUser(UserRegistration userRegistrationDto) throws CustomException;
	
	LoginResponse loginUser(UserLogin userLoginDto) throws CustomException;
	
	UserDetailsDto getMyDetails(HttpServletRequest request) throws CustomException;
}
