package com.ianskenny.guidemo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class GUIDemo5 {
    
    private JFrame frame;
    
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    
    private JPanel panel;
    
    private Random r;
    
    public GUIDemo5() {
    
        r = new Random();
        frame = new JFrame("GUI demo 5");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(new BorderLayout());
        JButton button = new JButton("Click me!");
        button.setFont(new Font("Serif", Font.BOLD, 14));
        
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int i = Math.abs(r.nextInt() % 255);
                int j = Math.abs(r.nextInt() % 255);
                int k = Math.abs(r.nextInt() % 255);
                label1.setBackground(new Color(i,j,k));   
                label2.setBackground(new Color(j,k,i));   
                label3.setBackground(new Color(k,i,j));   
                label4.setBackground(new Color(i,k,j));
            }
        });
        
        label1 = new JLabel("North");
        label1.setPreferredSize(new Dimension(100, 100));
        label1.setBackground(new Color(0,255,0));
        label1.setFont(new Font("Serif", Font.BOLD, 14));
        label1.setOpaque(true);

        label2 = new JLabel("West");
        label2.setPreferredSize(new Dimension(100, 100));
        label2.setBackground(new Color(255,0,255));
        label2.setFont(new Font("Serif", Font.BOLD, 14));
        label2.setOpaque(true);
        
        label3 = new JLabel("East");
        label3.setPreferredSize(new Dimension(100, 100));
        label3.setBackground(new Color(255,255,0));
        label3.setFont(new Font("Serif", Font.BOLD, 14));
        label3.setOpaque(true);

        label4 = new JLabel("Center");
        label4.setPreferredSize(new Dimension(100, 100));
        label4.setBackground(new Color(0,255,255));
        label4.setFont(new Font("Serif", Font.BOLD, 14));
        label4.setOpaque(true);

        panel.add(button, BorderLayout.SOUTH);
        panel.add(label1, BorderLayout.NORTH);
        panel.add(label2, BorderLayout.WEST);
        panel.add(label3, BorderLayout.EAST);
        panel.add(label4, BorderLayout.CENTER);
        
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main (String[] args) {
        GUIDemo5 g = new GUIDemo5();
    }    
}
