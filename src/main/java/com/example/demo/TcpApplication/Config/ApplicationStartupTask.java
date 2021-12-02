/*
 * package com.example.demo.TcpApplication.Config;
 * 
 * 
 * import com.example.demo.TcpApplication.Socket.NettyServerSocket;
 * 
 * import lombok.RequiredArgsConstructor;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.context.event.ApplicationReadyEvent; import
 * org.springframework.context.ApplicationEvent; import
 * org.springframework.context.ApplicationListener; import
 * org.springframework.stereotype.Component;
 * 
 * @Component
 * 
 * @RequiredArgsConstructor public class ApplicationStartupTask implements
 * ApplicationListener<ApplicationEvent>{
 * 
 * private final NettyServerSocket nettyServerSocket;
 * 
 * @Autowired
 * 
 * @Override public void onApplicationEvent(ApplicationReadyEvent event) {
 * nettyServerSocket.start(); }
 * 
 * }
 */