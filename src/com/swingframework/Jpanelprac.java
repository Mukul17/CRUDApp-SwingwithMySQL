package com.swingframework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Jpanelprac {

	private static String name;
	private static String name2;
	private static String query1,query2;
	private static String age;

	static Statement stmt;
	Connection con;
	private static JTextField jTextField = new JTextField();
	private static JTextField jTextField2 = new JTextField();
	private static JTextField jTextField3 = new JTextField();

	public static void main(String[] args) {

		// Adding a Frame
		JFrame jFrame = new JFrame("Database");
		// jFrame.setLayout(null);

		CardLayout cd = new CardLayout();

		jFrame.setLayout(null);

		// Customizing JFrame
		jFrame.setForeground(new Color(0x312509));

		// Jlabel
		JLabel jLabel = new JLabel("First Name");
		JLabel jLabel2 = new JLabel("Last Name");
		JLabel jLabel3 = new JLabel("Age");

		jLabel.setForeground(new Color(0x0E3B43));
		jLabel.setBounds(20, 60, 120, 120);

		jLabel2.setForeground(new Color(0x0E3B43));
		jLabel2.setBounds(20, 110, 120, 120);

		jLabel3.setForeground(new Color(0x0E3B43));
		jLabel3.setBounds(20, 150, 70, 120);

		ImageIcon imageIcon = new ImageIcon("D:/Eclispe/Swing/src/com/swingframework/image.png");
		JButton Button = new JButton();
		JButton Button2 = new JButton();
		JButton Button3 = new JButton();

		// jTextField.setEditable(true);
		jTextField.setBounds(100, 100, 200, 30);
		jTextField.setFont(new Font("SansSerif", Font.PLAIN, 20));

		// jTextField2.setEditable(true);
		jTextField2.setBounds(100, 150, 200, 30);
		jTextField2.setFont(new Font("SansSerif", Font.PLAIN, 20));

		jTextField3.setBounds(100, 200, 50, 30);
		jTextField3.setFont(new Font("SansSerif", Font.PLAIN, 20));

		// Jbutton setting properties

		Button.setBounds(50, 300, 100, 50);
		Button2.setBounds(180, 300, 100, 50);
		Button3.setBounds(90, 300, 200, 50);

		// setting jlabel setBOunds

//  jLabel.setIcon(imageIcon);
//	jTextField.setPreferredSize(new Dimension(50,50));
//	jFrame.add(jTextField);

		// adding components to Jframe to make it visible

//	jTextField.add(jLabel,BorderLayout.WEST);
//	jFrame.add(jPanel);

		// Button1 Configuration
		Button.setText("Update Database");
		Button.setFont(new Font("Comic Sans", Font.BOLD, 25));
		Button.setBackground(new Color(0x0D5D56));
		Button.setForeground(new Color(0x17C3B2));
		Button.setBorder(BorderFactory.createEtchedBorder());
		Button.setFocusable(false);

		// Button2 Configuration
		Button2.setText("Edit Values");
		Button2.setFont(new Font("Comic Sans", Font.BOLD, 25));
		Button2.setBackground(new Color(0x0329F5B));
		Button2.setForeground(new Color(0x17C3B2));
		Button2.setBorder(BorderFactory.createEtchedBorder());
		Button2.setFocusable(false);

		// Button3 Configuration
		Button3.setText("Third Button");
		Button3.setFont(new Font("Comic Sans", Font.BOLD, 25));
		Button3.setBackground(new Color(0xE9EDDE));
		Button3.setForeground(new Color(0x17C3B2));
		Button3.setBorder(BorderFactory.createEtchedBorder());
		Button3.setFocusable(false);

		// Creating Object and Connection
		Jpanelprac obj = new Jpanelprac();
		obj.connection();

		// Adding Action Listener whenever Button is Clicked
		Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == Button) {

					if (jTextField.getText().equals("") & (jTextField2.getText().equals(""))
							& jTextField3.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please Fill the Required Field", "MessageDialog",
								JOptionPane.ERROR_MESSAGE, null);
						System.out.println("Fields are Blank");
					}

					else {
						name = jTextField.getText();
						name2 = jTextField2.getText();
						age = jTextField3.getText();

						query1 = String.format("INSERT INTO PEOPLE VALUES('%s','%s','%s')", name, name2, age);
						try {
							int updatequery = stmt.executeUpdate(query1);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println(name);
						System.out.println(name2);
						System.out.println(age);

						JOptionPane.showMessageDialog(null, "Values Inserted in Database", "Database Updated",
								JOptionPane.INFORMATION_MESSAGE);

						// Setting the Text Field to Null again
						jTextField.setText("");
						jTextField2.setText("");
						jTextField3.setText("");
					}

				}

				/*
				 * if(e.getSource() ==Button2) cd.next(jFrame.getContentPane());
				 * if(e.getSource() ==Button3) cd.next(jFrame.getContentPane());
				 */

			}

		});
		
		Button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame jFrame2 = new JFrame("Edit Window");
				jFrame2.setBounds(100, 300, 50, 100);
				jFrame2.dispose();
				jFrame2.setLayout(null);

//			 	
//			    jLabel.setForeground(new Color(0xA11692));
//				jLabel.setBounds(20, 60, 120, 120);
//
//				jLabel2.setForeground(new Color(0xA11692));
//				jLabel2.setBounds(20, 110, 120, 120);
//
//				jLabel3.setForeground(new Color(0xA11692));
//				jLabel3.setBounds(20, 150, 70, 120);

				jFrame2.add(jLabel);
				jFrame2.add(jLabel2);
				jFrame2.add(jLabel3);
				jFrame2.add(jTextField);
				jFrame2.add(jTextField2);
				jFrame2.add(jTextField3);
				jFrame2.add(Button3);
						
				
			
					
				
				jFrame2.pack();
				jFrame2.setSize(500,500);
				jFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jFrame2.getContentPane().setBackground(new Color(0x4F86C6));
				jFrame2.setVisible(true);

			}

		});
		
		
		
		Button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				name = jTextField.getText();
				name2 = jTextField2.getText();
				age = jTextField3.getText();
				
				query2 = String.format("UPDATE PEOPLE SET first_name= '%s',last_name= '%s',age ='%s' WHERE first_name='Mukul' ",name, name2,age);
				try {
					int updatequery = stmt.executeUpdate(query2);
					JOptionPane.showMessageDialog(null, "Values Updated", "Values", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
			
		});
		
	
//		 Button3.addActionListener(new ActionListener() {
//		
//		 @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
//		 method stub
//		 
//		 cd.next(jFrame.getContentPane()); }
//		
//		 
//		
//		 });

		jFrame.add(jLabel);
		jFrame.add(jLabel2);
		jFrame.add(jLabel3);
		jFrame.add(jTextField);
		jFrame.add(jTextField2);
		jFrame.add(jTextField3);
		jFrame.add(Button);
		jFrame.add(Button2);
//	jFrame.add(Button3,"3");

		// Configuring JFrame at last
		jFrame.pack();
		jFrame.setSize(500, 500);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		jFrame.getContentPane().setBackground(new Color(0x9CAFB7));

//	//Red Panel
//	JPanel redPanel = new JPanel();
//	redPanel.setBackground(new Color(0x63342C));
//	redPanel.setBounds(250,0,250,250);
//	redPanel.add(jLabel);
//	jFrame.add(redPanel);
//	
//	//Blue
//	JPanel bluePanel = new JPanel();
//	bluePanel.setBackground(new Color(0x3C4367));
//	bluePanel.setBounds(0,0,250,250);
//	bluePanel.add(jLabel);
//	jFrame.add(bluePanel);

	}

//Establishing DataBase Connection
	void connection() {
		try {

			System.out.println("Inside Function");
			// Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/Dog";
			String username = "root";
			String pass = "Mukul1771@";
			con = DriverManager.getConnection(url, username, pass);
			System.out.println(con.getClass().getName());
			System.out.println("Conenction loaded");

			if (con.isClosed()) {
				System.out.println("Connection is closed");
			} else {
				System.out.println("Connection is established");
			}

			String q = "Select * from people";

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(q);

			// int q124 = stmt.executeQuery(q);

			String q12 = "SELECT * FROM PEOPLE ";

			ResultSet set = stmt.executeQuery(q);
			int index = set.findColumn("age");
			// System.out.println(updatequery);
			// System.out.println(set);

//
//	while(set.next()){
//		System.out.println(set.getInt(index));
//	}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
