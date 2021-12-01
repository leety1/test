package com.example.demo.TcpApplication;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class NettyServerBIO {

	public static void main(String[] args)throws IOException{
		ServerSocket server = new ServerSocket(8888);
		while(true) {
			Socket cl = server.accept();
			new Thread(new ServerThread(cl)).start();
		}
	}
}
	@Slf4j
	class ServerThread extends Thread{
	private Socket cl;
	public ServerThread(Socket client) {
		this.cl = cl;
	}
	@SneakyThrows
	@Override
	public void run() {
		log.info("Client:"+cl.getInetAddress().getLocalHost()+"Connected to Server");
		BufferedReader br = new BufferedReader(new InputStreamReader(cl.getInputStream()));
		String mess = br.readLine();
		log.info("Client"+mess);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(cl.getOutputStream()));
		bw.write(mess+"\n");
		bw.flush();
	}
}

