package com.example.demo.netty;

import com.example.demo.netty.TestDecoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NettyChannelInitializer extends ChannelInitializer<SocketChannel> {
	private final TestHandler tH;
	
	@Override
	protected void initChannel(SocketChannel ch) {
		ChannelPipeline pipeline = ch.pipeline();
		TestDecoder tD = new TestDecoder();
		pipeline.addLast(tD);
		pipeline.addLast(tH);
	}

}
