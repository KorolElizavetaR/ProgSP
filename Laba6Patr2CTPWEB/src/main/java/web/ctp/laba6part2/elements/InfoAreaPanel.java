package web.ctp.laba6part2.elements;

import java.awt.BorderLayout;

import javax.swing.*;

public class InfoAreaPanel extends JPanel {
    private JTextArea infoArea;

    public InfoAreaPanel() {
        setLayout(new BorderLayout());

        infoArea = new JTextArea(5, 20);
        infoArea.setEditable(false);
        add(new JScrollPane(infoArea), BorderLayout.CENTER);
    }

    public void setInfo(String info) {
        infoArea.setText(info);
    }
}
