package com.progsp.server.threads;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import com.progsp.server.MyServer;
import com.progsp.server.dao.ApartmentDAO;
import com.progsp.server.model.Apartment;

public class ApartmentFetcherThread extends Thread {
	private Socket socket;
	private static ApartmentDAO apartmentDAO = new ApartmentDAO();
	
	ApartmentFetcherThread(Socket socket)
	{
		super(() ->
		{
			MyServer.increaseClientCounter(); // нарушает S, но хз как иначе
			Scanner in = null;
			try {
				in = new Scanner(socket.getInputStream());
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		        int min = in.nextInt();
		        int max = in.nextInt();
		        List <Apartment> apartments =  apartmentDAO.fetchByMinMaxCost(min, max);
		       	for (Apartment apartment: apartments)
		       		out.println(apartment);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				in.close();
				MyServer.decreaseClientCounter();
				System.out.println("Thread is executed. Counter: " + MyServer.getClientCounter());
			}
		}
		);
		this.socket = socket;
	}
}
