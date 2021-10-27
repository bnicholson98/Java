package com.ianskenny.guidemo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.File; 


public class GUIDemo8a {
    
    private JFrame frame;
    private JPanel mainPanel;
    
    public GUIDemo8a() {
    
        frame = new JFrame("GUI demo 8a");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(300, 300));
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        
        JMenuItem openItem = new JMenuItem("Open");
        
        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Open")) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                    int result = fileChooser.showOpenDialog(frame);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    }        
                }
           }
        });
        
        JMenuItem closeItem = new JMenuItem("Close");
        
        fileMenu.add(openItem);
        fileMenu.add(closeItem);
                
        frame.setJMenuBar(menuBar);
        frame.add(mainPanel);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main (String[] args) {
        GUIDemo8a g = new GUIDemo8a();
    }    
}
