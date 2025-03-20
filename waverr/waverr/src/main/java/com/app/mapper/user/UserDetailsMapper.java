package com.app.mapper.user;


import com.app.dto.response.UserDetailsDto;
import com.app.model.User;

public class UserDetailsMapper {
	public static UserDetailsDto toUserDetailsDto(User user) {
		UserDetailsDto userDetailsDto = new UserDetailsDto();
		userDetailsDto.setFirstName(user.getFirstName());
		userDetailsDto.setLastName(user.getLastName());
		userDetailsDto.setBio(user.getBio());
		userDetailsDto.setGender(user.getGender());
		userDetailsDto.setProfileName(user.getProfileName());
		userDetailsDto.setProfileType(user.getProfileType()); 
		userDetailsDto.setPhoneNumber(user.getPhoneNumber());
		userDetailsDto.setDob(user.getDob());
		userDetailsDto.setCreatedAt(user.getCreatedAt());
		return userDetailsDto;
	}
}
