package com.swingframework;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class C_BorderLayout {

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(500,500);
		jFrame.setVisible(true);

		
		
		//JPanel creation
		JPanel redPanel = new JPanel();
		JPanel bluePanel = new JPanel();
		JPanel greenPanel = new JPanel();
		JPanel orangePanel = new JPanel();
		JPanel cyanPanel = new JPanel();
		
		
		
		//Giving Color to JPanel
		redPanel.setBackground( new Color(0xA8201A));
		bluePanel.setBackground(new Color(0x143642));
		greenPanel.setBackground(new Color(0x76B041));
		orangePanel.setBackground(new Color(0xE4572E));
		cyanPanel.setBackground(new Color(0x17BEBB));
		
		
		
		//Dimensions of JPanel
		
		redPanel.setPreferredSize(new Dimension(100,100));
		bluePanel.setPreferredSize(new Dimension(100,100));
		greenPanel.setPreferredSize(new Dimension(100,100));
		orangePanel.setPreferredSize(new Dimension(100,100));
		cyanPanel.setPreferredSize(new Dimension(100,100));
		
		//Adding Jpanel to Frame
		jFrame.add(redPanel,BorderLayout.NORTH);
		jFrame.add(bluePanel,BorderLayout.SOUTH);
		jFrame.add(greenPanel,BorderLayout.CENTER);
		jFrame.add(orangePanel,BorderLayout.WEST);
		jFrame.add(cyanPanel,BorderLayout.EAST);
		
		
		
	}

}
