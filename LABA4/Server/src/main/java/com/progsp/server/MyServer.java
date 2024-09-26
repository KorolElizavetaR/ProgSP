package com.progsp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Component ("myServer")
public class MyServer {
	@Getter
	private volatile static Integer clientCounter = 0;
	private static final Integer PORT = 1234;
	private static ServerSocket server;
	
	public MyServer() throws IOException {
		server = new ServerSocket(PORT);
	}
	
	public Socket getSocket() throws IOException
	{
		return server.accept();
	}
	
	public static void increaseClientCounter()
	{
		++clientCounter;
	}
	
	public static void decreaseClientCounter()
	{
		--clientCounter;
	}
}
