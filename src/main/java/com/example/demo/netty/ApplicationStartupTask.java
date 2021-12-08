package com.example.demo.netty;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationStartupTask implements ApplicationListener<ApplicationReadyEvent> {
	
	private final NettyServerSocket nettySS;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		nettySS.start();
		// TODO Auto-generated method stub
		
	}

}
