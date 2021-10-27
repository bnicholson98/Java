package com.ianskenny.guidemo;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class GUIDemo8 {
    
    private JFrame frame;
    private JPanel mainPanel;
    
    public GUIDemo8() {
    
        frame = new JFrame("GUI demo 8");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(300, 300));
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem closeItem = new JMenuItem("Close");
        
        fileMenu.add(openItem);
        fileMenu.add(closeItem);
                
        frame.setJMenuBar(menuBar);
        frame.add(mainPanel);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main (String[] args) {
        GUIDemo8 g = new GUIDemo8();
    }    
}
