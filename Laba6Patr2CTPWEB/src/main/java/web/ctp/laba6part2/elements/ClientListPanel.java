package web.ctp.laba6part2.elements;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ClientListPanel extends JPanel {
	private DefaultListModel<String> listModel;
	private JList<String> clientList;
	private JButton deleteButton;

	public ClientListPanel() {
		setLayout(new BorderLayout());

		// Модель списка клиентов
		listModel = new DefaultListModel<>();
		clientList = new JList<>(listModel);
		add(new JScrollPane(clientList), BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		deleteButton = new JButton("Удалить");
		buttonPanel.add(deleteButton);
		add(buttonPanel, BorderLayout.SOUTH);
		// Загрузка данных при запуске
		loadClientData();

		deleteButton.addActionListener(e -> {
			int selectedIndex = clientList.getSelectedIndex();
			if (selectedIndex != -1) {
				listModel.remove(selectedIndex);
			} else {
				JOptionPane.showMessageDialog(ClientListPanel.this, "Выберите запись для удаления", "Ошибка",
						JOptionPane.WARNING_MESSAGE);
			}
		});
	}

	public void addClient(String clientInfo) {
		listModel.addElement(clientInfo);
	}

	public void loadClientData() {
		try (BufferedReader reader = new BufferedReader(new FileReader("clients.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				listModel.addElement(line);
			}
		} catch (IOException e) {
			System.out.println("Не удалось загрузить данные клиентов.");
		}
	}

	public void saveClientData() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("clients.txt"))) {
			for (int i = 0; i < listModel.getSize(); i++) {
				writer.write(listModel.getElementAt(i));
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("Не удалось сохранить данные клиентов.");
		}
	}
}
