package com.bxn769;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Controller{
	protected GUI theGUI;
	protected Model theModel;
	
	public Controller(GUI theGUI, Model theModel){
		this.theGUI = theGUI;
		this.theModel = theModel;
		
		this.theGUI.addRankedListener(new RankedListener());
		this.theGUI.addNearestListener(new NearestListener());
	}
	
	class RankedListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			File frequencyFile;
			File cipherFile;
			
			try{
				frequencyFile = theGUI.getFrequencyFile();
				cipherFile = theGUI.getCipherFile();
				
				theModel.rankedEncryption(frequencyFile, cipherFile);
			}catch(FileNotFoundException ex){
				System.out.println(ex);
				theGUI.displayErrorMessage("You need to input files!");
			}catch (IOException ioEx){
				System.out.println(ioEx);
				theGUI.displayErrorMessage("IOException");
			}
		}
	}
	
	class NearestListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			File frequencyFile;
			File cipherFile;
			
			try{
				frequencyFile = theGUI.getFrequencyFile();
				cipherFile = theGUI.getCipherFile();
				
				theModel.nearestEncryption(frequencyFile, cipherFile);
			}catch(FileNotFoundException ex){
				System.out.println(ex);
				theGUI.displayErrorMessage("You need to input files!");
			}catch (IOException ioEx){
				System.out.println(ioEx);
				theGUI.displayErrorMessage("IOException");
			}
		}
	}
	
	
	
}
