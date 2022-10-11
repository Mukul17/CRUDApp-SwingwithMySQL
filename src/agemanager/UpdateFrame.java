package agemanager;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class UpdateFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFrame frame = new UpdateFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel updatePane = new JPanel();
		updatePane.setBounds(58, 51, 522, 326);
		contentPane.add(updatePane);
		updatePane.setLayout(null);

		ButtonGroup buttonGroup = new ButtonGroup();

		JRadioButton radioButtonFirstName = new JRadioButton("First Name");
		radioButtonFirstName.setFont(new Font("Arial Black", Font.PLAIN, 13));
		radioButtonFirstName.setBounds(36, 79, 116, 39);
		updatePane.add(radioButtonFirstName);
		radioButtonActionEvent(radioButtonFirstName);

		JRadioButton radioButtonLastName = new JRadioButton("Last Name");
		radioButtonLastName.setFont(new Font("Arial Black", Font.PLAIN, 14));
		radioButtonLastName.setBounds(196, 79, 109, 39);
		updatePane.add(radioButtonLastName);
		radioButtonActionEvent(radioButtonLastName);

		JRadioButton radioButtonAge = new JRadioButton("Age");
		radioButtonAge.setFont(new Font("Arial Black", Font.PLAIN, 14));
		radioButtonAge.setBounds(359, 79, 116, 39);
		updatePane.add(radioButtonAge);

		radioButtonActionEvent(radioButtonAge);
		
		
		buttonGroup.add(radioButtonFirstName);
		buttonGroup.add(radioButtonLastName);
		buttonGroup.add(radioButtonAge);

		JLabel lblNewLabel = new JLabel("Please Select the Condition For Change");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel.setLabelFor(radioButtonFirstName);
		lblNewLabel.setBounds(23, 11, 404, 30);
		updatePane.add(lblNewLabel);

		JLabel UpdateLabel = new JLabel("UpdateDatabaseSection");
		UpdateLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		UpdateLabel.setLabelFor(contentPane);
		UpdateLabel.setBounds(50, 11, 325, 29);
		contentPane.add(UpdateLabel);
	}
	
	
	void radioButtonActionEvent(JRadioButton button) {
		
		button.addActionListener(new Action() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(button.getText()+ "Radio Button");
			}
			
			@Override
			public void setEnabled(boolean b) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removePropertyChangeListener(PropertyChangeListener listener) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void putValue(String key, Object value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Object getValue(String key) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void addPropertyChangeListener(PropertyChangeListener listener) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
}
