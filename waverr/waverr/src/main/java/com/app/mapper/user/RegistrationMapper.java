package com.app.mapper.user;

import com.app.dto.response.LoginResponse;
import com.app.dto.user.UserRegistration;
import com.app.model.User;

public class RegistrationMapper {
	public static User toUser(UserRegistration userRegistrationDto) {
		User user = new User();
		
		user.setFirstName(userRegistrationDto.getFirstName());
		user.setLastName(userRegistrationDto.getLastName());
		user.setEmail(userRegistrationDto.getEmail());
		user.setPassword(userRegistrationDto.getPassword());
		
		return user;
	}
	public static LoginResponse toLoginResponse(User user,String token) {
		LoginResponse loginresponseDto = new LoginResponse();
		
		loginresponseDto.setFirstName(user.getFirstName());
		loginresponseDto.setLastName(user.getLastName());
		loginresponseDto.setBio(user.getBio());
		loginresponseDto.setGender(user.getGender());
		loginresponseDto.setProfileName(user.getProfileName());
		loginresponseDto.setProfileType(user.getProfileType()); // change this with userProfile picture in future
		loginresponseDto.setJwtToken(token);
		return loginresponseDto;
	}
}
