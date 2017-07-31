package de.jtheb.fh.lagerverwaltung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JTree warehouseTree;
    public JPanel panelMain;
    private JButton addNewItemButton;
    private JButton saveAndExitButton;
    private JButton getItemButton;
    private JTextArea nameTextArea;
    private JTextArea articleNrTextArea;
    private JTextArea heightTextArea;
    private JTextArea widthTextArea;
    private JTextArea depthTextArea;

    public Menu() {
        addNewItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Hello Get Item");
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        frame.setContentPane(new Menu().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
