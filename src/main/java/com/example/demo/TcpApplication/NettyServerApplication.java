package com.example.demo.TcpApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyServerApplication {
	public static void main(String[] args) {
		//이렇게 나눠써야 오류 안남
		SpringApplication application = new SpringApplication(NettyServerApplication.class);
		application.run(args);
	}

}
