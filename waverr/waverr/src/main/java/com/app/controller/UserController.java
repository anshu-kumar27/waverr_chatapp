package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.response.LoginResponse;
import com.app.dto.response.UserDetailsDto;
import com.app.dto.user.UserLogin;
import com.app.dto.user.UserRegistration;
import com.app.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
	private final UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<LoginResponse> registerUser(@Valid @RequestBody UserRegistration userRegistrationDto){
		LoginResponse loginResponse = userService.registerUser(userRegistrationDto);
		return new ResponseEntity<>(loginResponse,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody UserLogin userLoginDto){
		LoginResponse loginResponse = userService.loginUser(userLoginDto);
		return new ResponseEntity<>(loginResponse,HttpStatus.OK);
	}
	
	@GetMapping("/protected/me")
	public ResponseEntity<UserDetailsDto> getMyDetails(HttpServletRequest request){
		UserDetailsDto userDetailsDto = userService.getMyDetails(request);
		return new ResponseEntity<>(userDetailsDto,HttpStatus.OK);
	}
}
