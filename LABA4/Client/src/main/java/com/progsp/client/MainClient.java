package com.progsp.client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
	private static final int PORT = 1234;


    public static void main(String[] args) {
        try {
            Client();
        } catch (Exception e) {
            System.out.println(e.getMessage() + " : " + e.getCause());
        }
    }

    public static void Client() throws Exception
    {
        Socket socket = new Socket("localhost", PORT);
        Scanner scanner = new Scanner(System.in);
        Scanner in = new Scanner(socket.getInputStream());
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        System.out.print("A: ");
        int A = scanner.nextInt();
        System.out.print("B: ");
        int B = scanner.nextInt();

        out.println(A);
        out.println(B);

        int GCD = in.nextInt();
        System.out.println("GCD: " + GCD);
        socket.close();
    }
}
