package com.example.demo.client;

import lombok.extern.slf4j.Slf4j;
import java.io.*;
import java.net.Socket;



@Slf4j
public class NettyBioClient {
	public static void main(String[] args) throws IOException{
		try (Socket s = new Socket("0.0.0.0",10002)) {
			InputStream input = s.getInputStream();
			OutputStream output = s.getOutputStream();
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(output));
			bw.write("Client sends message test to server\n");
			bw.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			String mess = br.readLine();
			log.info("The Server:"+mess);
		}
		}
}
