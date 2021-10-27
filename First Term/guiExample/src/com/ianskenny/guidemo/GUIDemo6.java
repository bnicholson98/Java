package com.ianskenny.guidemo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIDemo6 {
    
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JTextField field;
    
    public GUIDemo6() {
        frame = new JFrame("GUI demo 6");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        label = new JLabel();
        panel.setPreferredSize(new Dimension(200, 100));
        field = new JTextField("What is your name?");
        field.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textFieldValue = field.getText();
                label.setText("Hello " + textFieldValue);
            }
        });
        
        field.setPreferredSize(new Dimension(150, 30));
        field.setBackground(new Color(0,255,0));
        field.setFont(new Font("Serif", Font.PLAIN, 12));
        field.setOpaque(true);
        panel.add(field);
        panel.add(label);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main (String[] args) {
        GUIDemo6 g = new GUIDemo6();
    }    
}
