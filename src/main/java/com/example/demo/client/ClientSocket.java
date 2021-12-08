package com.example.demo.client;

import com.google.common.io.ByteStreams;
import com.sun.nio.sctp.AssociationChangeNotification.AssocChangeEvent;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

@AllArgsConstructor
public class ClientSocket {
	private Socket socket;
	public void sendFixedLength(int messageL) {
		int delimiterLength = 256;
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<messageL;i++) {
			sb.append("A");
		}
		byte[] totalData = sb.toString().getBytes();
		System.out.println("Sending Message");
		try {
			OutputStream os = socket.getOutputStream();
			for(int i =0;i<messageL/delimiterLength;i++) {
				byte[] sending = Arrays.copyOfRange(totalData,i* delimiterLength, (i+1)*delimiterLength);
				System.out.println("sending..."+(i+1));
				os.write(sending);
				os.flush();
				Thread.sleep(500);
			}
		}
		catch(InterruptedException | IOException e) {
			e.printStackTrace();
		}
		System.out.println("Receiveing MEssage");
		try {
			InputStream is = socket.getInputStream();
			byte[] reply = new byte[messageL];
			ByteStreams.read(is, reply, 0, reply.length);
			System.out.println(new String(reply));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
