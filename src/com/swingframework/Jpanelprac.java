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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Jpanelprac  {
	
	static String name;
	static String name2;
	static String q1;
	
	static Statement stmt;
	Connection con;
	private static JTextField jTextField = new JTextField("Hello");
	private static JTextField jTextField2 = new JTextField("Hello1");
	
public static void main(String[]args) {
	
	//Adding a Frame 
	JFrame jFrame = new JFrame("Hello World");
	jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//JLabel jLabel = new JLabel();
	
	ImageIcon imageIcon = new ImageIcon("D:/Eclispe/Swing/src/com/swingframework/image.png");
	JButton Button = new JButton();
	
	
	//jTextField.setEditable(true);
	jTextField.setBounds(50,100,200,30);
	
	//jTextField2.setEditable(true);
	jTextField2.setBounds(50,150,200,30);

	
	//Jbutton setting properties
	
		Button.setBounds(100,300,200,100); 
		jFrame.add(Button);
		
	



//  jLabel.setIcon(imageIcon);
//	jTextField.setPreferredSize(new Dimension(50,50));
//	jFrame.add(jTextField);
	
		
		//adding components to Jframe to make it visible
		
	jFrame.add(jTextField);
	jFrame.add(jTextField2);
	
	
	
	
	//Button Configuration
	
	Button.setText("Click me");
	Button.setFont(new Font("Comic Sans",Font.BOLD,25));
	Button.setForeground(new Color(0x17C3B2));
	
	//Creating Object and Connection
	Jpanelprac obj = new Jpanelprac();
	obj.connection();
	
	//Adding Action Listener whenever Button is Clicked
	Button.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==Button) {
				
				 name= jTextField.getText();
				    name2=  jTextField2.getText();
				    
				    q1 = String.format("INSERT INTO PEOPLE VALUES('%s','%s',%d)",name,name2,2) ;
				    try {
						int updatequery = stmt.executeUpdate(q1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    System.out.println(name);
				    System.out.println(name2);
				
			}
			
			
		}
		
		
		
	}
	);
	
	

	//Configuring JFrame at last
	
	jFrame.setSize(500,500);
	jFrame.setLayout(null);
	jFrame.setVisible(true);
	
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
void connection(){
	try{
		
		System.out.println("Inside Function");
	//	Class.forName("com.mysql.cj.jdbc.Driver");
		
			String url = "jdbc:mysql://localhost:3306/Dog";
			String username="root";
			String pass="Mukul1771@";
		 con = DriverManager.getConnection(url,username,pass);
		System.out.println(con.getClass().getName());	
		System.out.println("Conenction loaded");
		
		if(con.isClosed()){
		System.out.println("Connection is closed");}
		else{
		System.out.println("Connection is established");}
		
	String q = "Select * from people";
	
	 stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(q);


	//int q124 = stmt.executeQuery(q);


	String q12 = "SELECT * FROM PEOPLE ";
	
	
	
	ResultSet set = stmt.executeQuery(q);
	int index = set.findColumn("age");
	//System.out.println(updatequery);
	//System.out.println(set);


//
//	while(set.next()){
//		System.out.println(set.getInt(index));
//	}




	}
	catch(Exception e){
	System.out.println(e);
	}

	
	}

	

}
