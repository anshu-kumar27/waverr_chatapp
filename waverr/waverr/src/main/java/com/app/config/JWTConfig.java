package com.app.config;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JWTConfig {
	private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	private static final long JWT_EXPIRY_TIME = 1 *60 *60 *1000; // hrs : min : secs : milisecs
	
	public static String generateToken(Long userId) {
		
		return Jwts.builder()
				.setSubject(String.valueOf(userId)) // payload or rather host
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+ JWT_EXPIRY_TIME))
				.signWith(SECRET_KEY) // our secret key to sign the jwtToken
				.compact(); // combination aka final key generation
	}
	
	public static Claims validateToken(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(SECRET_KEY)
				.build()
				.parseClaimsJws(token)
				.getBody(); //gets the payload userId in this case
	}
}
