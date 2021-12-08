package com.example.demo.client;

import lombok.extern.slf4j.Slf4j;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import com.example.demo.client.NonSslSocket;


@Slf4j
public class NettyBioClient {
	public static void main(String[] args) throws InterruptedException{
		String host = "127.0.0.1";
		int port = 8090;
		try {
			System.out.println("Enter message length");
			Scanner sc = new Scanner(System.in);
			int messageL = Integer.parseInt(host,port);
			NonSslSocket socket = new NonSslSocket(host,port);
			socket.run(messageL);
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
}
