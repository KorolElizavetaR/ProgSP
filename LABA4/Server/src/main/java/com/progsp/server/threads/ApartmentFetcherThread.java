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
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Accessors(chain = true)
@RequiredArgsConstructor
public class ApartmentFetcherThread extends Thread {
    @Setter
    private Socket socket;
    @Autowired
    private final ApartmentDAO apartmentDAO;

    @Override
    public void run() {
        MyServer.increaseClientCounter(); 
        try (Scanner in = new Scanner(socket.getInputStream());
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            while (!socket.isClosed()) { // Keep running until the client disconnects
                if (in.hasNextInt()) { // Wait for min and max input
                    int min = in.nextInt();
                    int max = in.nextInt();

                    // Check if the client sent the exit signal
                    if (min == -1 && max == -1) {
                        System.out.println("Received exit signal from client. Closing connection.");
                        break; // Exit the loop to close the connection
                    }

                    // Validate and adjust if min > max
                    if (min > max) {
                        int temp = min;
                        min = max;
                        max = temp;
                    }

                    // Fetch apartments and send back to client
                    List<Apartment> apartments = apartmentDAO.fetchByMinMaxCost(min, max);
                    for (Apartment apartment : apartments) {
                        out.println(apartment);
                    }
                    out.println("END"); // Signal end of response
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MyServer.decreaseClientCounter();
            System.out.println("Thread is executed. Counter: " + MyServer.getClientCounter());
        }
    }
}
