package com.progsp.server;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.progsp.server.threads.ClientHandler;

@SpringBootApplication
public class MainServer {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = SpringApplication.run(MainServer.class, args);
		ClientHandler thread = context.getBean(ClientHandler.class);
		thread.start();
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		thread.interrupt();
		scanner.close();
	}
}
