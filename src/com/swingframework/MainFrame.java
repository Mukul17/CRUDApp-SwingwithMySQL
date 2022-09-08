package com.swingframework;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	private JButton btn;
	private JTextArea jarea;
	private JLabel jlabel;
	private JPanel jPanel;
	private JPanel jPanel2;
	private JFrame jFrame2;
	
	
	public MainFrame() {
		super("Hello World");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon imageIcon = new ImageIcon("D:/Eclispe/Swing/src/com/swingframework/calculator.jpg","image icon");
		setIconImage(imageIcon.getImage());
		
		//Setting the Layout
		setLayout(new BorderLayout());
		
		//initializing components
		jarea= new JTextArea();
		btn = new JButton("Click Me!");
		jlabel = new JLabel();
	   
		
		
		//Configuring the components
		add(jarea, BorderLayout.CENTER);
		add(btn,BorderLayout.SOUTH);
		add(jlabel);
		
		
		//adding action listener to button
		btn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Hello");
				jarea.append("Hello\n");
			}
			
			
			
			
		});
		
		
	
	
		
//		jlable construc
		
		jlabel.setText("Creating Frame");
		jlabel.setForeground(new Color(0x282182));
		
		getContentPane().setBackground(new Color(0x61E786));
		setTitle("My First Frame");
		setSize(600,500);
		setVisible(true);
		setResizable(false);
		setLayout(null);
		
	
		
		//JPanel 
				jPanel2 = new JPanel();
				jPanel2.setBackground(new Color(0x3DFF33));
				jPanel2.setBounds(250,0,250,0);
				jFrame2.add(jPanel2);
		
		
				 jFrame2 = new JFrame();
					//JPanel 
					jPanel = new JPanel();
					jPanel.setBackground(new Color(0x282182));
					jPanel.setBounds(250,0,250,0);
					jFrame2.add(jPanel);
		
		
		
	
	}
	
	
	
	
}
