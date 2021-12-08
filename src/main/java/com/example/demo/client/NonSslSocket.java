package com.example.demo.client;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

@AllArgsConstructor
public class NonSslSocket {
	private String host;
	private int port;
	public void run(int messageL) {
		try {
			Socket so = new Socket();
			SocketAddress add = new InetSocketAddress(host,port);
			so.connect(add);
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
	}


}
