package com.progsp.server.threads;

import java.io.IOException;

import com.progsp.server.MyServer;

public class ClientHandler extends Thread{
	static MyServer instance = null;
	
	public ClientHandler() throws IOException {
		instance = MyServer.getInstanceOfMyServer();
	}
	
	@Override
	public void run() {

		while (!Thread.currentThread().isInterrupted()) {
			try
			{
			//LogicThread executionThread = new LogicThread(instance.getSocket());
			ApartmentFetcherThread executionThread = new ApartmentFetcherThread(instance.getSocket());
			executionThread.start();
			Thread.sleep(1);
			System.out.println("Thread started execution: " + MyServer.getClientCounter());
			}
			catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		} 
	}

}
