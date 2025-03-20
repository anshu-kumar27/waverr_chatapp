package com.app.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.app.model.enums.Gender;
import com.app.model.enums.ProfileType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {
	private String firstName;
	private String lastName;
	private String bio;
	private String profileName;
	private Gender gender;
	private ProfileType profileType;
	private String phoneNumber;
	private LocalDate dob;
	private LocalDateTime createdAt;
}
