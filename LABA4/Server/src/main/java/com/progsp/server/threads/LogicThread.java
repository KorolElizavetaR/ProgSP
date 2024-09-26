//package com.progsp.server.threads;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.util.Scanner;
//
//import com.progsp.server.MyServer;
//
//public class LogicThread extends Thread{
//	private Socket socket;
//	
//	LogicThread(Socket socket)
//	{
//		super(() ->
//		{
//			MyServer.increaseClientCounter(); // нарушает S, но хз как иначе
//			Scanner in = null;
//			try {
//				in = new Scanner(socket.getInputStream());
//				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//		        int A = in.nextInt();
//		        int B = in.nextInt();
//		        out.println(A+B);
//			} catch (IOException e) {
//				e.printStackTrace();
//			} finally {
//				in.close();
//				MyServer.decreaseClientCounter();
//				System.out.println("Thread is executed. Counter: " + MyServer.getClientCounter());
//			}
//		}
//		);
//		this.socket = socket;
//	}
//}
