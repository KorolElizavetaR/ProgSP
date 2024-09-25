package com.progsp.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ExecutedThread extends Thread{
	private Socket socket;
	
	ExecutedThread(Socket socket)
	{
		super();
		this.socket = socket;
	}
	
	@Override
	public void run() {
		MyServer.increaseClientCounter(); // нарушает S, но хз как иначе
		Scanner in = null;
		try {
			in = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	        System.out.print("Input awaited....");
	        int A = in.nextInt();
	        int B = in.nextInt();
	        out.println(A+B);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			in.close();
			MyServer.decreaseClientCounter();
			System.out.println("Thread is executed. Counter: " + MyServer.getClientCounter());
		}
	}
}
