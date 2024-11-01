//package com.progsp.client;
//
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class MainClient {
//	private static final int PORT = 1234;
//
//
//    public static void main(String[] args) {
//        try {
//            Client();
//        } catch (Exception e) {
//            System.out.println(e.getMessage() + " : " + e.getCause());
//        }
//    }
//
//    public static void Client() throws Exception
//    {
//        Socket socket = new Socket("localhost", PORT);
//        Scanner scanner = new Scanner(System.in);
//        Scanner in = new Scanner(socket.getInputStream());
//        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//
//        System.out.print("Min: ");
//        int min = scanner.nextInt();
//        System.out.print("Max: ");
//        int max = scanner.nextInt();
//
//        out.println(min);
//        out.println(max);
//        
//        while (in.hasNextLine())
//        {
//        	System.out.println(in.nextLine());
//        }
//       
//        socket.close();
//    }
//}
