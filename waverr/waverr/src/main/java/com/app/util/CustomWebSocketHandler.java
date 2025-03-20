package com.app.util;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class CustomWebSocketHandler extends TextWebSocketHandler{
	private static final ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
		
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String userId = (String) session.getAttributes().get("userId");
		if(userId != null) {
			sessions.put(userId,session);
			System.out.println("user Connected "+userId);
		}
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session,TextMessage message) throws Exception{
		String payload = message.getPayload();
		System.out.print("Received message : "+payload);
		session.sendMessage(new TextMessage("Message received : "+payload));
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session,CloseStatus status) throws Exception {
		String userId = (String)session.getAttributes().get("userId");
		if(userId != null) {
			sessions.remove(userId);
			System.out.println("User Disconnected : "+userId);
		}
	}
}
