package com.ianskenny.guidemo;
import javax.swing.*;
import java.awt.*;

public class GUIDemo1 {
    
    private JFrame frame;
    
    public GUIDemo1() {
        frame = new JFrame("GUI demo 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("I am a label!");
        label.setPreferredSize(new Dimension(500, 500));
        label.setBackground(new Color(0,255,0));
        label.setFont(new Font("Serif", Font.PLAIN, 40));
        label.setOpaque(true);
        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main (String[] args) {
        GUIDemo1 g = new GUIDemo1();
    }    
}
