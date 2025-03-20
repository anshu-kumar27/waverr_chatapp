package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.middleware.JWTFilter;
import com.app.repository.UserRepository;

@Configuration
public class SecurityConfig {
	@Autowired
	UserRepository userRepository;
	
	@Bean
	PasswordEncoder passwordEncorder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	FilterRegistrationBean<JWTFilter> jwtFilter(UserRepository userRepository){
		FilterRegistrationBean<JWTFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new JWTFilter(userRepository));
		registrationBean.addUrlPatterns("/api/user/protected/*");
		return registrationBean;
		
	}
}
