package agemanager;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UpdateFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField aadharNumberTextField;

	//private static ExecuteQueryHandlerImpl databaseManager = new DatabaseManager();
	private static JTextField firstNameTextField;
	private static JTextField lastNameTextField;
	private static JTextField ageTextField;
	private static JLabel aadharNumberLabel;
	private static JButton aadharNumberSearchButton;
	private static JLabel firstNameLabel;
	private static JLabel lastNameLabel;
	private static JLabel ageLabel;
	private static JButton cancelButton;
	static private JButton saveButton;
	static private boolean isAdharNumberCorrect;
	static String aadharNumString;
	static private JButton backToMainMenu;
	static UpdateFrame frame;
	static Person person;
	static UpdateQueryHandlerImpl handler = new UpdateQueryHandlerImpl();
	static ExecuteQueryHandlerImpl handlerImpl = new ExecuteQueryHandlerImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UpdateFrame();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public UpdateFrame() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel updatePane = new JPanel();
		updatePane.setBounds(58, 51, 517, 365);
		contentPane.add(updatePane);
		updatePane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Please Enter Adhar Card Number");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));

		lblNewLabel.setBounds(23, 11, 404, 30);
		updatePane.add(lblNewLabel);

		aadharNumberTextField = new JTextField();

		aadharNumberTextField.setBounds(197, 52, 204, 39);
		updatePane.add(aadharNumberTextField);
		aadharNumberTextField.setColumns(10);

		aadharNumberLabel = new JLabel("Aadhar Number");
		aadharNumberLabel.setLabelFor(aadharNumberTextField);
		aadharNumberLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		aadharNumberLabel.setBounds(33, 52, 95, 39);
		updatePane.add(aadharNumberLabel);

		aadharNumberSearchButton = new JButton("Search");
		aadharNumberSearchButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		aadharNumberSearchButton.setBounds(197, 102, 204, 30);
		updatePane.add(aadharNumberSearchButton);

		buttonActionEvent(aadharNumberSearchButton);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(185, 88, 121, 30);
		updatePane.add(firstNameTextField);
		firstNameTextField.setColumns(10);
		firstNameTextField.setVisible(false);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(185, 125, 121, 30);
		updatePane.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		lastNameTextField.setVisible(false);

		ageTextField = new JTextField();
		ageTextField.setBounds(185, 165, 121, 30);
		updatePane.add(ageTextField);
		ageTextField.setColumns(10);
		ageTextField.setVisible(false);

		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		firstNameLabel.setBounds(51, 87, 77, 30);
		updatePane.add(firstNameLabel);
		firstNameLabel.setVisible(false);

		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lastNameLabel.setBounds(51, 128, 77, 22);
		updatePane.add(lastNameLabel);
		lastNameLabel.setVisible(false);

		ageLabel = new JLabel("Age");
		ageLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		ageLabel.setBounds(51, 168, 77, 22);
		updatePane.add(ageLabel);

		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(80, 232, 107, 30);
		updatePane.add(cancelButton);
		cancelButton.setVisible(false);

		saveButton = new JButton("Save");
		saveButton.setBounds(235, 232, 116, 30);
		updatePane.add(saveButton);
		ageLabel.setVisible(false);
		saveButton.setVisible(false);

		JLabel UpdateLabel = new JLabel("UpdateDatabaseSection");
		UpdateLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		UpdateLabel.setLabelFor(contentPane);
		UpdateLabel.setBounds(50, 11, 325, 29);
		contentPane.add(UpdateLabel);

		cancelButon(cancelButton);

		saveButon(saveButton);

		backToMainMenu = new JButton("Main Menu");
		backToMainMenu.setBounds(197, 148, 204, 30);
		updatePane.add(backToMainMenu);

		backToMenuButton(backToMainMenu);
	}

	static void backToMenuButton(JButton button) {

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				HomeScreen.main(null);
				frame.dispose();
			}

		});

	}

	static void textFieldActionListener(JTextField textField) {

		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				saveButton.setVisible(true);
				saveButton.setEnabled(true);

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				saveButton.setVisible(false);
			}

		});

	}

	static void createQuery(String aadharNumString) {

		String queryString = String.format("SELECT * FROM PEOPLE WHERE adhar_num ='%s' ", aadharNumString);

		try {

			ResultSet executeQueryResultSet = handlerImpl.executeQueryMethodResultSet(queryString);

			while (executeQueryResultSet.next()) {

				firstNameTextField.setText(executeQueryResultSet.getString("first_name"));
				lastNameTextField.setText(executeQueryResultSet.getString("last_name"));
				ageTextField.setText(executeQueryResultSet.getString("age"));
				textFieldActionListener(firstNameTextField);
				textFieldActionListener(lastNameTextField);
				textFieldActionListener(ageTextField);
				isAdharNumberCorrect = true;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

	}

	static void cancelButon(JButton button) {

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				firstNameTextField.setVisible(false);
				firstNameLabel.setVisible(false);
				lastNameLabel.setVisible(false);
				lastNameTextField.setVisible(false);
				ageTextField.setVisible(false);
				ageLabel.setVisible(false);
				aadharNumberLabel.setVisible(true);
				aadharNumberTextField.setVisible(true);
				aadharNumberSearchButton.setVisible(true);
				button.setVisible(false);
				firstNameTextField.setText("");
				lastNameTextField.setText("");
				ageTextField.setText("");
				backToMainMenu.setVisible(true);
			}

		});
	}

	static void saveButon(JButton jButton) throws SQLException {

		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				System.out.println(firstNameTextField.getText());
				System.out.println(lastNameTextField.getText());
				System.out.println(ageTextField.getText());
				System.out.println(aadharNumString);
				String queryString = String.format(

						"UPDATE PEOPLE SET first_name ='%s', last_name ='%s', age ='%s' WHERE adhar_num ='%s' ",
						firstNameTextField.getText(), lastNameTextField.getText(), ageTextField.getText(),
						aadharNumString);
				try {
					 handler.updateQueriesHandler(queryString);
				} catch (SQLException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}

		});

	}

	static void buttonActionEvent(JButton button) throws SQLException {

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				aadharNumString = aadharNumberTextField.getText();
				System.out.println(aadharNumString);

				if (aadharNumString.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter Aadhar Number");
				}

				else {

					UpdateFrame.createQuery(aadharNumString);

					if (isAdharNumberCorrect == true) {
						backToMainMenu.setVisible(false);
						aadharNumberTextField.setVisible(false);
						aadharNumberLabel.setVisible(false);
						aadharNumberSearchButton.setVisible(false);

						cancelButton.setVisible(true);

						saveButton.setEnabled(false);
						firstNameTextField.setVisible(true);
						lastNameTextField.setVisible(true);
						ageTextField.setVisible(true);
						firstNameLabel.setVisible(true);
						lastNameLabel.setVisible(true);
						ageLabel.setVisible(true);

						aadharNumberTextField.setText("");
					}

					else {
						JOptionPane.showMessageDialog(null, "Aadhar Number did not Match our Records");
					}

				}

			}

		});
	}

}
