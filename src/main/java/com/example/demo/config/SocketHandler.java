package com.example.demo.config;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class SocketHandler extends TextWebSocketHandler {

    List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
        System.out.println(session+"성공 이건 핸들러");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
        System.out.println(session+"닫힘");
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws IOException {
    	String request = message.getPayload();
    	System.out.println("Server received: "+"{"+request+"}");
    	String response = String.format("response from server to '%s'", HtmlUtils.htmlEscape(request));
    	System.out.println("Server received: "+"{"+response+"}");
        for (WebSocketSession webSocketSession : sessions) {
            if (!session.equals(webSocketSession)) {
                webSocketSession.sendMessage(message);
            }
            System.out.println(session+"돌기");
        }
    }
}
