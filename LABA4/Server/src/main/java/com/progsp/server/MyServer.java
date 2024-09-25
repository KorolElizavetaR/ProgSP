package com.progsp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import lombok.Getter;

public class MyServer {
	@Getter
	private static Integer clientCounter = 0;
	private static final Integer PORT = 1234;
	private static ServerSocket server;
	static MyServer instanceOfMyServer;
	
	private MyServer() throws IOException {
		server = new ServerSocket(PORT);
	}
	
	public static MyServer getInstanceOfMyServer() throws IOException
	{
		if (instanceOfMyServer == null)
			return new MyServer();
		return instanceOfMyServer;
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
