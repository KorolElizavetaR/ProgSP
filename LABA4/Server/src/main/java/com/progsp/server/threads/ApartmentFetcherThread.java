package com.progsp.server.threads;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.progsp.server.MyServer;
import com.progsp.server.dao.ApartmentDAO;
import com.progsp.server.model.Apartment;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Component 
@Scope (ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Accessors (chain = true)
@RequiredArgsConstructor
public class ApartmentFetcherThread extends Thread {
	@Setter
	private Socket socket;
	@Autowired
	private final ApartmentDAO apartmentDAO;
	
	@Override
	public void run() {
		MyServer.increaseClientCounter(); // нарушает S, но хз как иначе
		Scanner in = null;
		try {
			in = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	        int min = in.nextInt();
	        int max = in.nextInt();
	        if (min > max)
	        {
	        	int tmp = min;
	        	min = max;
	        	max = tmp;
	        }
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
}
