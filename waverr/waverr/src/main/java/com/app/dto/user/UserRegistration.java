package com.app.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistration {
	
	@NotBlank(message = "First name is required.")
	@Size(min = 4, max = 50,message = "First name should be in between 4 to 50 chars.")
	private String firstName;
	
	@Size(max = 50,message = "Last name cannot exceed 50 chars.")
	private String lastName;
	
	@NotBlank(message = "Email is required.")
	@Email(message = "Please type a valid email adress.")
	private String email; 
	
	@NotBlank(message = "Password is required.")
	@Size(min = 8, max = 50,message = "Password should be in between 8 to 50 chars.")
	private String password;
	
	@NotBlank(message = "Confirm password is required.")
	@Size(min = 8, max = 50,message = "Confirm password should be in between 8 to 50 chars.")
	private String confirmPassword;
}
