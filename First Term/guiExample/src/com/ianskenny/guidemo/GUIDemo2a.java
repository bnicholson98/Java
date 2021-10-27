package com.ianskenny.guidemo;
import javax.swing.*;
import java.awt.*;

public class GUIDemo2a {
    
    private JFrame frame;
    
    public GUIDemo2a() {
        frame = new JFrame("GUI demo 2a");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JButton button = new JButton("Click me!");
        button.setFont(new Font("Serif", Font.BOLD, 14));
        JLabel label = new JLabel("I am a label!");
        label.setPreferredSize(new Dimension(500, 500));
        label.setBackground(new Color(0,255,0));
        label.setFont(new Font("Serif", Font.PLAIN, 40));
        label.setOpaque(true);
        panel.add(button);
        panel.add(label);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main (String[] args) {
        GUIDemo2a g = new GUIDemo2a();
    }    
}
