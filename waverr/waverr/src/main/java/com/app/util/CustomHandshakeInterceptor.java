package com.app.util;

import java.util.Map;

import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;

import jakarta.servlet.http.HttpSession;

public class CustomHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
			WebSocketHandler webSocketHandler, Map<String, Object> attributes) throws Exception {

		try {

			if (request instanceof ServletServerHttpRequest servletRequest) {
				HttpSession httpSession = servletRequest.getServletRequest().getSession();
				String userId = (String) httpSession.getAttribute("userId");

				if (userId != null) {
					attributes.put("userId", userId);
					return true;
				}
			}
		} catch (Exception e) {
			System.err.println("Error During websocket creation : " + e.getMessage());
		}
		response.setStatusCode(org.springframework.http.HttpStatus.UNAUTHORIZED);
		return false;

	}
}
