package com.ianskenny.guidemo;
import javax.swing.*;
import java.awt.*;

public class GUIDemo1a {
    
    private JFrame frame;
    
    public GUIDemo1a() {
        frame = new JFrame("GUI demo 1a");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("I am a label!");
        label.setPreferredSize(new Dimension(500, 500));
        label.setBackground(new Color(0,255,0));
        label.setFont(new Font("Serif", Font.PLAIN, 40));
        label.setOpaque(true);
        panel.add(label);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main (String[] args) {
        GUIDemo1a g = new GUIDemo1a();
    }    
}
