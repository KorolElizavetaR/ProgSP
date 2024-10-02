package com.progsp.laba6.element;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lombok.Getter;

@Getter
public class TextPanel extends JPanel {
	private JButton addButton;
	private JButton deleteButton;
	private JTextField inputField;
	private JPanel inputPanel = new JPanel(new BorderLayout());;

	public TextPanel() {
		initElements();
		inputPanel.add(inputField, BorderLayout.CENTER); // Позволяем полю занимать все доступное пространство
        inputPanel.add(addButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.CENTER);
        add(deleteButton, BorderLayout.EAST);
	}

	private void initElements() {
		inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(200, 30));  // Задаем предпочтительный размер поля

        addButton = new JButton("Добавить");
        deleteButton = new JButton("Удалить");
	}
}
