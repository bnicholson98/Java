package com.bxn769;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class FADecrypter{
    public static void main(String[] args) {
		
        GUI theGUI = new GUI();
        Model theModel = new Model();
        Controller theController = new Controller(theGUI,theModel);

    }

}
