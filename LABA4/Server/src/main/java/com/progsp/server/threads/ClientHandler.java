package com.progsp.server.threads;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.progsp.server.MyServer;

import lombok.RequiredArgsConstructor;

@Component ("clientHandler")
@RequiredArgsConstructor
public class ClientHandler extends Thread{
	@Autowired
	private final MyServer instance;
	@Autowired
	private final AnnotationConfigApplicationContext context;
	
	@Override
	public void run() {

		while (!Thread.currentThread().isInterrupted()) {
			try
			{
			ApartmentFetcherThread executionThread = context.
					getBean("apartmentFetcherThread", ApartmentFetcherThread.class).
					setSocket(instance.getSocket());
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
