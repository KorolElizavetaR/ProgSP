package web.ctp.laba6part2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class SalonRegistration extends JFrame {
    private JTextField nameField;
    private JTextField phoneField;
    private JComboBox<String> serviceBox;
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private JCheckBox agreeCheckBox;
    private JList<String> clientList;
    private DefaultListModel<String> listModel;
    private JButton registerButton;
    private JTextArea infoArea = new JTextArea(5, 20);;
    private ButtonGroup genderGroup ;

    public SalonRegistration() {
        setTitle("Регистрация в салон");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Панель ввода данных
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(7, 2));

        // Имя
        inputPanel.add(new JLabel("Имя:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        // Телефон
        inputPanel.add(new JLabel("Телефон:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        // Услуги
        inputPanel.add(new JLabel("Услуга:"));
        String[] services = {"Стрижка", "Маникюр", "Массаж", "Косметология"};
        serviceBox = new JComboBox<>(services);
        inputPanel.add(serviceBox);

        // Пол
        inputPanel.add(new JLabel("Пол:"));
        maleRadio = new JRadioButton("Мужской");
        femaleRadio = new JRadioButton("Женский");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        inputPanel.add(genderPanel);

        // Согласие на обработку данных
        agreeCheckBox = new JCheckBox("Согласен на обработку данных");
        inputPanel.add(agreeCheckBox);

        // Кнопка регистрации
        registerButton = new JButton("Регистрация");
        inputPanel.add(registerButton);

        add(inputPanel, BorderLayout.NORTH);

        // Список клиентов
        listModel = new DefaultListModel<>();
        clientList = new JList<>(listModel);
        loadClientData();
        add(new JScrollPane(clientList), BorderLayout.CENTER);

        infoArea.setEditable(false);
        add(new JScrollPane(infoArea), BorderLayout.SOUTH);

        // Обработчик кнопки регистрации
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerClient();
            }
        });

        // Закрытие окна с сохранением данных
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveClientData();
                System.exit(0);
            }
        });
    }

    private void registerClient() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String service = (String) serviceBox.getSelectedItem();
        String gender = maleRadio.isSelected() ? "Мужской" : femaleRadio.isSelected() ? "Женский" : "";
        boolean agreed = agreeCheckBox.isSelected();

        if (name.isEmpty() || phone.isEmpty() || gender.isEmpty() || !agreed) {
            infoArea.setText("Пожалуйста, заполните все поля и согласитесь на обработку данных.");
            return;
        }

        String clientInfo = String.format("%s (%s), Телефон: %s, Услуга: %s", name, gender, phone, service);
        listModel.addElement(clientInfo);
        infoArea.setText("Клиент зарегистрирован: " + clientInfo);

        // Очистка полей
        nameField.setText("");
        phoneField.setText("");
        genderGroup.clearSelection();
        agreeCheckBox.setSelected(false);
    }

    private void loadClientData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("clients.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listModel.addElement(line);
            }
        } catch (IOException e) {
            infoArea.setText("Не удалось загрузить данные клиентов.");
        }
    }

    private void saveClientData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("clients.txt"))) {
            for (int i = 0; i < listModel.getSize(); i++) {
                writer.write(listModel.getElementAt(i));
                writer.newLine();
            }
        } catch (IOException e) {
            infoArea.setText("Не удалось сохранить данные клиентов.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SalonRegistration frame = new SalonRegistration();
            frame.setVisible(true);
        });
    }
}
