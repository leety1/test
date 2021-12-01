package com.example.demo.TcpApplication.Config;

import com.example.demo.TcpApplication.Config.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

@Configuration
@RequiredArgsConstructor
public class NettyConfiguration {
	
	@Value("${server.host}")
	private String host;
	@Value("${server.port}")
	private int port;
	@Value("${server.netty.boss-count}")
	private int boseCount;
	@Value("${server.netty.worker-count}")
	private int workerCount;
	@Value("${server.netty.keep-alive}")
	private boolean keepAlice;
	@Value("${server.netty.backlog}")
	private int backlog;
	
	@Bean
	

}
