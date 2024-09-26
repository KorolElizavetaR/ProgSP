package com.progsp.server;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.progsp.server.config.ConfigClass;
import com.progsp.server.threads.ClientHandler;

public class MainServer {
	
	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
		ClientHandler thread = context.getBean("clientHandler", ClientHandler.class);
//			ClientHandler thread = new ClientHandler();
			thread.start();
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
			thread.interrupt();
		}
}
