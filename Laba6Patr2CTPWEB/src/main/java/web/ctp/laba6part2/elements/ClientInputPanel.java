package web.ctp.laba6part2.elements;

import javax.swing.*;
import java.awt.*;

public class ClientInputPanel extends JPanel {
    private JTextField nameField;
    private JTextField phoneField;
    private JComboBox<String> serviceBox;
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private JCheckBox agreeCheckBox;
    private JButton registerButton;

    public ClientInputPanel() {
        setLayout(new GridLayout(7, 2));

        // Имя
        add(new JLabel("Имя:"));
        nameField = new JTextField();
        add(nameField);

        // Телефон
        add(new JLabel("Телефон:"));
        phoneField = new JTextField();
        add(phoneField);

        // Услуга
        add(new JLabel("Услуга:"));
        String[] services = {"Стрижка", "Маникюр", "Массаж", "Косметология"};
        serviceBox = new JComboBox<>(services);
        add(serviceBox);

        // Пол
        add(new JLabel("Пол:"));
        maleRadio = new JRadioButton("Мужской");
        femaleRadio = new JRadioButton("Женский");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        add(genderPanel);

        // Согласие
        agreeCheckBox = new JCheckBox("Согласен на обработку данных");
        add(agreeCheckBox);

        // Кнопка регистрации
        registerButton = new JButton("Регистрация");
        add(registerButton);
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public String getClientInfo() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String service = (String) serviceBox.getSelectedItem();
        String gender = maleRadio.isSelected() ? "Мужской" : femaleRadio.isSelected() ? "Женский" : "";
        boolean agreed = agreeCheckBox.isSelected();

        if (name.isEmpty() || phone.isEmpty() || gender.isEmpty() || !agreed) {
            return null;
        }

        return String.format("%s (%s), Телефон: %s, Услуга: %s", name, gender, phone, service);
    }

    public void clearFields() {
        nameField.setText("");
        phoneField.setText("");
        maleRadio.setSelected(false);
        femaleRadio.setSelected(false);
        agreeCheckBox.setSelected(false);
    }
}
