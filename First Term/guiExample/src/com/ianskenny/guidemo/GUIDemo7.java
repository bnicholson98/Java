package com.ianskenny.guidemo;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class GUIDemo7 {
    
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel qlabel;
    private JLabel rlabel;
    private JTextField field;
    private JSlider slider;
    private JPanel sliderPanel;
    
    public GUIDemo7() {
    
        frame = new JFrame("GUI demo 7");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(300, 100));

        qlabel = new JLabel("How are you today?");
        qlabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(qlabel, BorderLayout.NORTH);
        
        rlabel = new JLabel();
        rlabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(rlabel, BorderLayout.SOUTH);

        sliderPanel = new JPanel();
        
        slider = new JSlider(JSlider.HORIZONTAL);
               
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                Integer val = new Integer(slider.getValue());
                if (val >= 70)
                    rlabel.setText("That bad, huh?");
                else if (val >=30 && val < 70)
                    rlabel.setText("Not too bad, huh?");
                else rlabel.setText("Wow, you're feeling great!");
            }
        });
                        
        ImageIcon icon = new ImageIcon("Smiley.png");
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        JLabel smiley = new JLabel();
        smiley.setIcon(icon);
        sliderPanel.add(smiley, BorderLayout.WEST);
        
        sliderPanel.add(slider);
                
        icon = new ImageIcon("Sad.png");
        image = icon.getImage();
        newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        JLabel sad = new JLabel();
        sad.setIcon(icon);
        sliderPanel.add(sad, BorderLayout.EAST);

        mainPanel.add(sliderPanel,BorderLayout.CENTER);
        frame.add(mainPanel);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main (String[] args) {
        GUIDemo7 g = new GUIDemo7();
    }    
}
