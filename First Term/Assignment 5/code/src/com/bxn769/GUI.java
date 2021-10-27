/** package being used */
package com.bxn769;
/** Appropriate packages for GUI and file handling imported */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.File; 


/**
The GUI class
*/
public class GUI{
	/** Creates the GUI window frame variable */
	protected JFrame frame;
	
	protected JPanel topPanel;
	protected JPanel middlePanel;
	protected JPanel bottomPanel;
	protected JLabel frequencyLabel;
	protected JLabel cipherLabel;
	
	protected File frequencyFile;
	protected File cipherFile;
	
	protected JButton rankedButton;		
	protected JButton nearestButton;;
	
	
	public GUI(){
		/** Declares the frame and sets it to close on exit */
		frame = new JFrame("Frequency Analysis Decryption");
		frame.setLayout(new BorderLayout());
		//frame.setPreferredSize(new Dimension(480,320));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		topPanel = new JPanel(new BorderLayout());
		middlePanel = new JPanel(new BorderLayout());
		bottomPanel = new JPanel(new BorderLayout());
		
		frequencyLabel= new JLabel("Letter frequency file: ");
		frequencyLabel.setPreferredSize(new Dimension(320,160));
		frequencyLabel.setFont(new Font("Serif", Font.PLAIN, 32));
		frequencyLabel.setOpaque(true);
		
		JButton frequencyButton = new JButton("Browse...");
		frequencyButton.setFont(new Font("Serif", Font.ITALIC+Font.BOLD, 12));
		
		frequencyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (e.getActionCommand().equals("Browse...")){
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
					int result = fileChooser.showOpenDialog(frame);
					if (result == JFileChooser.APPROVE_OPTION){
						frequencyFile = fileChooser.getSelectedFile();
						System.out.println("Frequency file: "+frequencyFile.getAbsolutePath());
					}
				}
			}
		});
		
		cipherLabel= new JLabel("Cipher text file: ");
		cipherLabel.setPreferredSize(new Dimension(320,160));
		cipherLabel.setFont(new Font("Serif", Font.PLAIN, 32));
		cipherLabel.setOpaque(true);
		
		JButton cipherButton = new JButton("Browse...");
		cipherButton.setFont(new Font("Serif", Font.ITALIC+Font.BOLD, 12));
		
		cipherButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (e.getActionCommand().equals("Browse...")){
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
					int result = fileChooser.showOpenDialog(frame);
					if (result == JFileChooser.APPROVE_OPTION){
						cipherFile = fileChooser.getSelectedFile();
						System.out.println("Cipher file: "+cipherFile.getAbsolutePath());
					}
				}
			}
		});
		
		rankedButton = new JButton("Ranked frequency");
		rankedButton.setFont(new Font("Serif", Font.BOLD, 12));
		
		nearestButton = new JButton("Nearest frequency");
		nearestButton.setFont(new Font("Serif", Font.BOLD, 12));
		
		topPanel.add(frequencyLabel, BorderLayout.WEST);
		topPanel.add(frequencyButton, BorderLayout.EAST);
		middlePanel.add(cipherLabel, BorderLayout.WEST);
		middlePanel.add(cipherButton, BorderLayout.EAST);
		bottomPanel.add(rankedButton, BorderLayout.WEST);
		bottomPanel.add(nearestButton, BorderLayout.EAST);;
		
		frame.add(topPanel, BorderLayout.NORTH);
		frame.add(middlePanel, BorderLayout.CENTER);
		frame.add(bottomPanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
	
	public File getFrequencyFile(){
		return frequencyFile;
	}
	
	public File getCipherFile(){
		return cipherFile;
	}
	
	void addRankedListener(ActionListener listenForRankedButton){
		rankedButton.addActionListener(listenForRankedButton);
	}
	
	void addNearestListener(ActionListener listenForNearestButton){
		nearestButton.addActionListener(listenForNearestButton);
	}
	
	void displayErrorMessage(String errorMessage){
		JOptionPane.showMessageDialog(frame, errorMessage);
	}
	
	
	
	public static void main (String[] args) {
        GUI g = new GUI();
    }  
	
}