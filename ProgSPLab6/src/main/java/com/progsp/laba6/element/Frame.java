package com.progsp.laba6.element;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Frame extends JFrame {

	private Table table = new Table();
	private JScrollPane tableScrollPane;
	private TextPanel textPanel = new TextPanel();

	public Frame() {
		setTitle("Лаба 6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		initElements();
		addActionListenerToButtons();
		addElements();
	}

	private void addElements() {
		add(tableScrollPane, BorderLayout.CENTER);
		add(textPanel, BorderLayout.SOUTH);
	}

	private void initElements() {
		tableScrollPane = new JScrollPane(table);
	}

	private void addActionListenerToButtons() {
		textPanel.getAddButton().addActionListener(e -> {
			if (Table.getTableModel().getRowCount() >= Table.getTABLE_LIMIT()) {
				JOptionPane.showMessageDialog(null, "Запрещаю добавлять человеков", "Лимит достигнут",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			String input = textPanel.getInputField().getText().trim();
			if (!input.isEmpty()) {
				String[] fio = input.split(" ");
				if (fio.length == 3) {
					Table.getTableModel().addRow(new Object[] { fio[0], fio[1], fio[2] });
					textPanel.getInputField().setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Неверный формат фио", "Ошибка ввода",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		textPanel.getDeleteButton().addActionListener(e -> {
			int selectedRow = table.getSelectedRow();
			if (selectedRow != -1) {
				Table.getTableModel().removeRow(selectedRow);
			} else {
				JOptionPane.showMessageDialog(null, "Выберите запись для удаления", "Ошибка",
						JOptionPane.ERROR_MESSAGE);
			}
		});
	}
}
