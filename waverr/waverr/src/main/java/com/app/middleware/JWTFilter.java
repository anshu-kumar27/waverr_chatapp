package com.app.middleware;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.web.filter.OncePerRequestFilter;

import com.app.config.JWTConfig;
import com.app.exception.CustomException;
import com.app.model.User;
import com.app.repository.UserRepository;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class JWTFilter extends OncePerRequestFilter {
	private final UserRepository userrepo;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authHeader = request.getHeader("Authorization");
		
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String token = authHeader.substring(7);
			try {
				Claims claims = JWTConfig.validateToken(token);
				Long userId = Long.parseLong(claims.getSubject()); // this returns the userId;
				User user = userrepo.findById(userId).orElseThrow(()-> new CustomException("User Not found during authentication",404));

				request.setAttribute("claims", claims);
				request.setAttribute("user", user);

			}catch (Exception e) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write("Unauthorized "+e.getMessage());
				return;
			}
		
		filterChain.doFilter(request, response);
		
	}
	
	public void authenticateRole(HttpServletRequest request,String... role) {
		User user = (User)request.getAttribute("user");
		String userRole = user.getRole().toString();
		if(Arrays.stream(role).noneMatch(userRole::equals)) {
			throw new CustomException("UnAuthorized", 401);
		}
		
	}
}

