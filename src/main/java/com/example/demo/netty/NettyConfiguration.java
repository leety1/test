package com.example.demo.netty;

import com.example.demo.netty.NettyChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
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
	
	public NettyChannelInitializer nettyI;
	
	@Value("${server.host}")
	private String host;
	@Value("${server.port}")
	private int port;
	@Value("${server.netty.boss-count}")
	private int bossCnt;
	@Value("${server.netty.worker-count}")
    private int workerCount;
    @Value("${server.netty.keep-alive}")
    private boolean keepAlive;
    @Value("${server.netty.backlog}")
    private int backlog;
    
    @Bean
    public ServerBootstrap serverBootstrap(NettyChannelInitializer nettyCI) {
    	ServerBootstrap sb=new ServerBootstrap();
    	
		sb.group(bossGroup(),workerGroup())
    		.channel(NioServerSocketChannel.class)
    		.handler(new LoggingHandler(LogLevel.DEBUG))
    		.childHandler(null);
		sb.option(ChannelOption.SO_BACKLOG, backlog);
    	return sb;
    }
    //boss : incoming connection 수락, 수락한 connection 을 worker에 등록
    @Bean(destroyMethod = "shutdownGracefully")
	public NioEventLoopGroup bossGroup() {
		// TODO Auto-generated method stub
		return new NioEventLoopGroup(bossCnt);
	}
    //worker: boss 가 수락한 연결의 트래픽 관리
    @Bean(destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup workerGroup() {
		// TODO Auto-generated method stub
		return new NioEventLoopGroup(workerCount);
	}
    //IP 소켓주소 를 구현
    //도메인 이름으로 객체 생성 가능
    @Bean
    public InetSocketAddress inetSocketAddress() {
    	return new InetSocketAddress(host,port);
    }
	

}
