package com.progsp.server;

import java.io.IOException;

public class MainServer {
	public static void main(String[] args) {
		try {
			MyServer instance = MyServer.getInstanceOfMyServer();
			
			do {
				ExecutedThread thread = new ExecutedThread(instance.getSocket());
				thread.start();
			} while (MyServer.getClientCounter() > 0);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
