package com.progsp.server;

import java.io.IOException;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

public class MainServer {
	public static void main(String[] args) throws IOException {
			MyServer instance = MyServer.getInstanceOfMyServer();
			
			Thread thread = new Thread(() -> {
				while (!Thread.currentThread().isInterrupted()) {
					try
					{
					ExecutedThread executionThread = new ExecutedThread(instance.getSocket());
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
			);
			thread.start();
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
			thread.interrupt();
		}
}
