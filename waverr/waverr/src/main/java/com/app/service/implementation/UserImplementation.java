package com.app.service.implementation;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.config.JWTConfig;
import com.app.dto.response.LoginResponse;
import com.app.dto.response.UserDetailsDto;
import com.app.dto.user.UserLogin;
import com.app.dto.user.UserRegistration;
import com.app.exception.CustomException;
import com.app.mapper.user.RegistrationMapper;
import com.app.mapper.user.UserDetailsMapper;
import com.app.model.User;
import com.app.repository.UserRepository;
import com.app.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserImplementation implements UserService {
	public final UserRepository userRepo;
	public final PasswordEncoder passwordEncoder;

	@Override
	public LoginResponse registerUser(UserRegistration userRegistrationDto) {
		userRepo.findByEmail(userRegistrationDto.getEmail()).ifPresent(existingUser -> {
			throw new CustomException("User already exists", 409);
		});

		if (!userRegistrationDto.getPassword().equals(userRegistrationDto.getConfirmPassword()))
			throw new CustomException("Password and confirm Password are different", 400);

		try {
			User user = RegistrationMapper.toUser(userRegistrationDto);
			String hashedPassword = passwordEncoder.encode(userRegistrationDto.getPassword());
			user.setPassword(hashedPassword);
			userRepo.save(user);
			String token = JWTConfig.generateToken(user.getUserId());
			return 	RegistrationMapper.toLoginResponse(user, token);
		} catch (Exception e) {
			throw new CustomException("An error occured during Registration " + e.getMessage(), 500);
		}
	}
	
	
	@Override
	public LoginResponse loginUser(UserLogin userLoginDto) {
		User user = userRepo.findByEmail(userLoginDto.getEmail()).orElseThrow(()->new CustomException("Invalid Email or Password", 401));
		
		if(!passwordEncoder.matches(userLoginDto.getPassword(),user.getPassword() )) {
			throw new CustomException("Invalid Email or Password", 401);
		}
		try {
			String token = JWTConfig.generateToken(user.getUserId());
			return RegistrationMapper.toLoginResponse(user,token);
		}catch (Exception e) {
			throw new CustomException("An error occured during login "+e.getMessage(),500);
		}
		
	}


	@Override
	public UserDetailsDto getMyDetails(HttpServletRequest request) throws CustomException {
		User user = (User)request.getAttribute("user");
		if(user == null) throw new CustomException("user not found in request content",400);

		return UserDetailsMapper.toUserDetailsDto(user);
	}
}
