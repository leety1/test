package com.example.demo.config;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
@Component
public class SocketHandler implements WebSocketHandler {

	List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
	public void handleTextMessage(WebSocketSession session, TextMessage msg) throws InterruptedException,IOException{
		 
		for(WebSocketSession webSocketSession : sessions) {
			if(webSocketSession.isOpen()&&!session.getId().equals(webSocketSession.getId())) {
				webSocketSession.sendMessage(msg);
			}
		}
		String load =msg.getPayload();
		
		System.out.println(msg+"핸들러 연결 함"+load);
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		sessions.add(session);
		System.out.println(session+"연결 함");
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(exception);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

}
