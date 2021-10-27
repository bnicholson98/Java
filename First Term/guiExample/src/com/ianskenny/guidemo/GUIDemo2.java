package com.ianskenny.guidemo;
import javax.swing.*;
import java.awt.*;

public class GUIDemo2 {
    
    private JFrame frame;
    
    public GUIDemo2() {
        frame = new JFrame("GUI demo 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JButton button = new JButton("Click me!");
        button.setFont(new Font("Serif", Font.BOLD, 14));
        JLabel label = new JLabel("I am a label!");
        label.setPreferredSize(new Dimension(500, 500));
        label.setBackground(new Color(0,255,0));
        label.setFont(new Font("Serif", Font.PLAIN, 40));
        label.setOpaque(true);
        panel.add(label);
        panel.add(button);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main (String[] args) {
        GUIDemo2 g = new GUIDemo2();
    }    
}
