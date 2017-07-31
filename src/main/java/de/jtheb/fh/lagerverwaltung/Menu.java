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
    private JTextArea nameTextPane;
    private JTextArea articleNrTextPane;
    private JTextArea heightTextPane;
    private JTextArea widthTextPane;
    private JTextArea depthTextPane;

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
