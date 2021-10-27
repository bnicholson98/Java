package com.ianskenny.guidemo;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.io.File; 

public class GUIDemo9 {
    
    private JFrame frame;
    
    public GUIDemo9() {
    
        frame = new JFrame("GUI demo 9");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }        
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main (String[] args) {
        GUIDemo9 g = new GUIDemo9();
    }    
}
