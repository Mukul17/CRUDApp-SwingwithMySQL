package swingframework;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import practiceSwingFrameworksClasses.Dialogbox_creation;

public class SwingAppWithMySql implements Dialogbox_creation {

	private static String editFramefirstName;
	private static String editFrameLastName;
	private static String query1, query2;
	private static String editFrameAge;

	static Statement stmt;
	Connection con;

	private static JTextField firstNameTextField = new JTextField();
	private static JTextField lastNameTextField = new JTextField();
	private static JTextField ageTextField = new JTextField();
	private static JFrame frontPageFrame;

	public static void main(String[] args) {

		frontPageFrame = new JFrame("Database");
		frontPageFrame.setLayout(null);
		frontPageFrame.setForeground(new Color(0x312509));

		JLabel firstNameLabel = new JLabel("First Name");
		JLabel lastNameLabel = new JLabel("Last Name");
		JLabel ageLabel = new JLabel("Age");

		settingLabelsBoundsAndFonts(firstNameLabel, lastNameLabel, ageLabel);

		JButton addButton = new JButton();
		JButton editButton = new JButton();
		JButton updateButton = new JButton();

		settingTextFieldsBoundsAndFonts();

		addButton.setBounds(50, 300, 100, 50);
		editButton.setBounds(180, 300, 100, 50);
		updateButton.setBounds(90, 300, 200, 50);

		configureAddButton(addButton);

		configureEditButton(editButton);

		configureUpdateButton(updateButton);

		SwingAppWithMySql obj = new SwingAppWithMySql();

		obj.connection();

		addButtonWhichConnectsWithDatabase(addButton);

		ediButtonClicked(firstNameLabel, lastNameLabel, ageLabel, editButton, updateButton);

		updateButtonInsideEditInsertsUpdatedValues(updateButton);

		addingComponentsToFrontPageFrame(firstNameLabel, lastNameLabel, ageLabel, addButton, editButton);

		frontPageFrameDefaultProperties();

	}

	private static void frontPageFrameDefaultProperties() {
		frontPageFrame.pack();
		frontPageFrame.setSize(500, 500);
		frontPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frontPageFrame.setVisible(true);
		frontPageFrame.getContentPane().setBackground(new Color(0x9CAFB7));
	}

	private static void addingComponentsToFrontPageFrame(JLabel firstNameLabel, JLabel lastNameLabel, JLabel ageLabel,
			JButton addButton, JButton editButton) {
		frontPageFrame.add(firstNameLabel);
		frontPageFrame.add(lastNameLabel);
		frontPageFrame.add(ageLabel);
		frontPageFrame.add(firstNameTextField);
		frontPageFrame.add(lastNameTextField);
		frontPageFrame.add(ageTextField);
		frontPageFrame.add(addButton);
		frontPageFrame.add(editButton);
	}

	private static void settingLabelsBoundsAndFonts(JLabel firstNameLabel, JLabel lastNameLabel, JLabel ageLabel) {
		firstNameLabel.setForeground(new Color(0x0E3B43));
		firstNameLabel.setBounds(20, 60, 120, 120);

		lastNameLabel.setForeground(new Color(0x0E3B43));
		lastNameLabel.setBounds(20, 110, 120, 120);

		ageLabel.setForeground(new Color(0x0E3B43));
		ageLabel.setBounds(20, 150, 70, 120);
	}

	private static void settingTextFieldsBoundsAndFonts() {
		firstNameTextField.setBounds(100, 100, 200, 30);
		firstNameTextField.setFont(new Font("SansSerif", Font.PLAIN, 20));

		lastNameTextField.setBounds(100, 150, 200, 30);
		lastNameTextField.setFont(new Font("SansSerif", Font.PLAIN, 20));

		ageTextField.setBounds(100, 200, 50, 30);
		ageTextField.setFont(new Font("SansSerif", Font.PLAIN, 20));
	}

	private static void configureUpdateButton(JButton updateButton) {
		updateButton.setText("Update");
		updateButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
		updateButton.setBackground(new Color(0xE9EDDE));
		updateButton.setForeground(new Color(0x17C3B2));
		updateButton.setBorder(BorderFactory.createEtchedBorder());
		updateButton.setFocusable(false);
	}

	private static void configureEditButton(JButton editButton) {

		editButton.setText("Edit");
		editButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
		editButton.setBackground(new Color(0x0329F5B));
		editButton.setForeground(new Color(0x17C3B2));
		editButton.setBorder(BorderFactory.createEtchedBorder());
		editButton.setFocusable(false);
	}

	private static void configureAddButton(JButton addButton) {
		addButton.setText("Add");
		addButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
		addButton.setBackground(new Color(0x0D5D56));
		addButton.setForeground(new Color(0x17C3B2));
		addButton.setBorder(BorderFactory.createEtchedBorder());
		addButton.setFocusable(false);
	}

	private static void ediButtonClicked(JLabel firstNameLabel, JLabel lastNameLabel, JLabel ageLabel, JButton Button2,
			JButton Button3) {
		Button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame updateScreenFrame = new JFrame("Edit Window");
				updateScreenFrame.setBounds(100, 300, 50, 100);
				updateScreenFrame.dispose();
				updateScreenFrame.setLayout(null);

				addingComponentsToUpdateScreenFrame(firstNameLabel, lastNameLabel, ageLabel, Button3,
						updateScreenFrame);

				updateScreenFrameDefaultConfiguration(updateScreenFrame);

			}

			private void updateScreenFrameDefaultConfiguration(JFrame updateScreenFrame) {
				updateScreenFrame.pack();
				updateScreenFrame.setSize(500, 500);
				updateScreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				updateScreenFrame.getContentPane().setBackground(new Color(0x4F86C6));
				updateScreenFrame.setVisible(true);
			}

			private void addingComponentsToUpdateScreenFrame(JLabel firstNameLabel, JLabel lastNameLabel,
					JLabel ageLabel, JButton Button3, JFrame updateScreenFrame) {
				updateScreenFrame.add(firstNameLabel);
				updateScreenFrame.add(lastNameLabel);
				updateScreenFrame.add(ageLabel);
				updateScreenFrame.add(firstNameTextField);
				updateScreenFrame.add(lastNameTextField);
				updateScreenFrame.add(ageTextField);
				updateScreenFrame.add(Button3);
			}

		});
	}

	static boolean validateRequiredFields(String firstName, String lastName, String age) {

		if (firstNameTextField.getText().equals("") & (lastNameTextField.getText().equals(""))
				& ageTextField.getText().equals("")) {
			showErrorMessage("Please Fill the Required Field");
			System.out.println("Fields are Blank");
			return true;
		}

		else if (firstNameTextField.getText().equals("") & (lastNameTextField.getText().equals(""))) {
			showErrorMessage("Please Fill the Required Field");
			return true;
		}

		else if (lastNameTextField.getText().equals("") & (ageTextField.getText().equals(""))) {
			showErrorMessage("Please Fill the Required Field");
			return true;
		}

		return false;

	}

	private static void showErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage, "MessageDialog",
				JOptionPane.ERROR_MESSAGE, null);
	}

	private static void updateButtonInsideEditInsertsUpdatedValues(JButton Button3) {

		Button3.addActionListener(new ActionListener() {
			boolean isValidate;

			@Override
			public void actionPerformed(ActionEvent e) {

				editFramefirstName = firstNameTextField.getText();
				editFrameLastName = lastNameTextField.getText();
				editFrameAge = ageTextField.getText();

				isValidate = validateRequiredFields(editFramefirstName, editFrameLastName, editFrameAge);

				if (isValidate == true) {

				} else {
					query2 = String.format(
							"UPDATE PEOPLE SET first_name= '%s',last_name= '%s',age ='%s' WHERE first_name='%s' ",
							editFramefirstName, editFrameLastName, editFrameAge, editFramefirstName);
					try {
						int updatequery = stmt.executeUpdate(query2);
						JOptionPane.showMessageDialog(null, "Values Updated", "Values",
								JOptionPane.INFORMATION_MESSAGE);

						JOptionPane.showMessageDialog(null, updatequery, "", JOptionPane.INFORMATION_MESSAGE);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					firstNameTextField.setText("");
					lastNameTextField.setText("");
					ageTextField.setText("");

				}

			}
		});
	}

	private static void addButtonWhichConnectsWithDatabase(JButton Button) {
		Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				validationLogic(Button, e);
			}

			private void validationLogic(JButton Button, ActionEvent e) throws HeadlessException {

				if (e.getSource() == Button) {

					if (firstNameTextField.getText().equals("") & (lastNameTextField.getText().equals(""))
							& ageTextField.getText().equals("")) {
						showMessageDialogForError();

					}

					else if (firstNameTextField.getText().equals("") & (lastNameTextField.getText().equals(""))) {
						showMessageDialogForError();
					}

					else if (lastNameTextField.getText().equals("") & (ageTextField.getText().equals(""))) {
						showMessageDialogForError();
					}

					else {
						editFramefirstName = firstNameTextField.getText();
						editFrameLastName = lastNameTextField.getText();
						editFrameAge = ageTextField.getText();

						query1 = String.format("INSERT INTO PEOPLE VALUES('%s','%s','%s')", editFramefirstName,
								editFrameLastName, editFrameAge);
						try {
							int updatequery = stmt.executeUpdate(query1);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							e1.getMessage();
						}
						System.out.println(editFramefirstName);
						System.out.println(editFrameLastName);
						System.out.println(editFrameAge);

						showMessageDialogForInformation();

						// Setting the Text Field to Null again
						firstNameTextField.setText("");
						lastNameTextField.setText("");
						ageTextField.setText("");

					}

				}
			}

			private void showMessageDialogForInformation() {
				JOptionPane.showMessageDialog(null, "Values Inserted in Database", "Database Updated",
						JOptionPane.INFORMATION_MESSAGE);
			}

			private void showMessageDialogForError() {
				showErrorMessage("Please Fill the Required Field");
			}

		});
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
			stmt.executeQuery(q);

			String q12 = "SELECT * FROM PEOPLE ";

			ResultSet set = stmt.executeQuery(q);
			int index = set.findColumn("age");
			// System.out.println(updatequery);
			// System.out.println(set);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public JDialog createDialog() {
		JDialog dialog;
		return dialog = new JDialog(frontPageFrame, "DialogWindow");

	}

}
