package com.ianskenny.guidemo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.File; 


public class GUIDemo11 {
    
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel sciPanel;
    
    public GUIDemo11() {
    
        frame = new JFrame("GUI demo 8a");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(300, 300));
        mainPanel.add(new JLabel("Main"));
        sciPanel = new JPanel();
        sciPanel.setPreferredSize(new Dimension(200, 300));
        sciPanel.add(new JLabel("Sci"));
        
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
        
        closeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Close")) {
                    frame.getContentPane().add(sciPanel);
                    frame.pack();
                    frame.repaint();
              }
           }
        });

        fileMenu.add(openItem);
        fileMenu.add(closeItem);
                
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(mainPanel);
//        frame.getContentPane().add(sciPanel);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main (String[] args) {
        GUIDemo11 g = new GUIDemo11();
    }    
}
