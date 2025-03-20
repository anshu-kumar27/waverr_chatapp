package com.app.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLogin {
	
	//@Email(message = "Please Type a valid Email.")
	//@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Please enter a valid email.")
	
	@NotBlank(message = "Email can not be blank.")
	@Email(message = "Please Type a valid Email.")
	private String email;
	
	@NotBlank(message = "Password can not be blank.")
	@Size(min = 8,max=50,message = "Password length should be between 8 to 50")
	private String password;
}
