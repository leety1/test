package com.example.demo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@ChannelHandler.Sharable
@RequiredArgsConstructor
public class TestHandler extends ChannelInboundHandlerAdapter{
	private int DATA_LENGTH = 2048;
	private ByteBuf buff;
	
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) {
		buff = ctx.alloc().buffer(DATA_LENGTH);
	}
	
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) {
		buff = null;
	}
	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		String remoteAddr = ctx.channel().remoteAddress().toString();
		log.info("REMOTE ADDRESS"+remoteAddr);
	}
	@Override
	public void channelRead(ChannelHandlerContext ctx,Object msg) {
		ByteBuf mBuf=(ByteBuf) msg;
		buff.writeBytes(mBuf);
		mBuf.release();
		
		final ChannelFuture f = ctx.writeAndFlush(buff);
		f.addListener(ChannelFutureListener.CLOSE);
	}

	public void exceptionmCaught(ChannelHandlerContext ctx,Throwable cause) {
		ctx.close();
		cause.printStackTrace();
	}
	

}
