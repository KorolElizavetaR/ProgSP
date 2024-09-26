package com.progsp.server;

import java.io.IOException;
import java.util.Scanner;

import com.progsp.server.threads.ClientHandler;
import com.progsp.server.threads.LogicThread;


public class MainServer {
	public static void main(String[] args) throws IOException {
			ClientHandler thread = new ClientHandler();
			thread.start();
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
			thread.interrupt();
		}
}
