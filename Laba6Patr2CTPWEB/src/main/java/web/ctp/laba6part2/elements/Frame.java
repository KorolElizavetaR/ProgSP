package web.ctp.laba6part2.elements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame{
	private ClientInputPanel clientInputPanel;
    private ClientListPanel clientListPanel;
    private InfoAreaPanel infoAreaPanel;
    
    public Frame() {
        setTitle("Регистрация в салон");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Инициализация панелей
        clientInputPanel = new ClientInputPanel();
        clientListPanel = new ClientListPanel();
        infoAreaPanel = new InfoAreaPanel();

        // Добавляем панели в основное окно
        add(clientInputPanel, BorderLayout.NORTH);
        add(clientListPanel, BorderLayout.CENTER);
        add(infoAreaPanel, BorderLayout.SOUTH);

        // Обработчик кнопки регистрации
        clientInputPanel.getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String clientInfo = clientInputPanel.getClientInfo();
                if (clientInfo != null) {
                    clientListPanel.addClient(clientInfo);
                    infoAreaPanel.setInfo("Клиент зарегистрирован: " + clientInfo);
                    clientInputPanel.clearFields();
                } else {
                    infoAreaPanel.setInfo("Заполните все поля.");
                }
            }
        });

        // Закрытие окна с сохранением данных
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                clientListPanel.saveClientData();
                System.exit(0);
            }
        });
    }
}
