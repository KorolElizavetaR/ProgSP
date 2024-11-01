package com.progsp.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainClientGUI extends JFrame {
    private static final int PORT = 1234;
    private Socket socket;
    private PrintWriter out;
    private Scanner in;

    private JTextField minField;
    private JTextField maxField;
    private JTextArea resultArea;
    private JButton fetchButton;

    public MainClientGUI() {
        setTitle("Apartment Finder");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 5, 5));

        inputPanel.add(new JLabel("Min Price:"));
        minField = new JTextField();
        inputPanel.add(minField);

        inputPanel.add(new JLabel("Max Price:"));
        maxField = new JTextField();
        inputPanel.add(maxField);

        fetchButton = new JButton("Fetch Apartments");
        inputPanel.add(fetchButton);

        add(inputPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);

        fetchButton.addActionListener(new FetchButtonListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                sendExitSignal(); // Send exit signal on window close
                closeConnection(); // Ensure connection is closed on window close
            }
        });

        initializeConnection(); // Start connection
        setVisible(true);
    }

    private void initializeConnection() {
        try {
            socket = new Socket("localhost", PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new Scanner(socket.getInputStream());
        } catch (Exception e) {
            resultArea.setText("Could not connect to server: " + e.getMessage());
            fetchButton.setEnabled(false); // Disable fetch button if connection fails
        }
    }

    private void fetchApartments() {
        try {
            int min = Integer.parseInt(minField.getText());
            int max = Integer.parseInt(maxField.getText());
            resultArea.setText(""); // Clear previous results

            out.println(min);
            out.println(max);

            // Read server response
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if ("END".equals(line)) { // End of current response
                    break;
                }
                resultArea.append(line + "\n");
            }
        } catch (Exception e) {
            resultArea.setText("Error: " + e.getMessage());
        }
    }

    private void sendExitSignal() {
        // Sends the exit signal (-1 -1) to the server
        if (out != null) {
            out.println(-1);
            out.println(-1);
        }
    }

    private void closeConnection() {
        try {
            if (socket != null) {
                socket.close();
            }
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }

    private class FetchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            fetchApartments();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainClientGUI::new);
    }
}
