package agemanager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AgeManager {

	private static String editFramefirstName;
	private static String editFrameLastName;
	private static String query1, query2;
	private static String editFrameAge;
	static private DatabaseManager databaseManager;

	private static JTextField firstNameTextField = new JTextField();
	private static JTextField lastNameTextField = new JTextField();
	private static JTextField ageTextField = new JTextField();
	private static JFrame frontPageFrame;

	static JButton readButton;
	static JButton addButton;
	static JButton editButton;
	static JButton updateButton;

	public AgeManager(DatabaseManager databaseManager) {
		AgeManager.databaseManager = databaseManager;
	}

	public static void main(String[] args) {

		databaseManager = new DatabaseManager();
		
		frontPageFrame = new JFrame("Database");
		frontPageFrame.getContentPane().setLayout(null);
		frontPageFrame.setForeground(new Color(0x312509));

		JLabel firstNameLabel = new JLabel("First Name");
		JLabel lastNameLabel = new JLabel("Last Name");
		JLabel ageLabel = new JLabel("Age");

		settingLabelsBoundsAndFonts(firstNameLabel, lastNameLabel, ageLabel);

		addButton = new JButton();
		editButton = new JButton();
		updateButton = new JButton();
		readButton = new JButton();

		settingTextFieldsBoundsAndFonts();

		addButton.setBounds(50, 300, 100, 50);
		editButton.setBounds(180, 300, 100, 50);
		updateButton.setBounds(90, 300, 200, 50);
		readButton.setBounds(300, 300, 100, 50);

		configureAddButton(addButton);

		configureEditButton(editButton);

		configureUpdateButton(updateButton);

		configureReadButton(readButton);

		AgeManager obj = new AgeManager(new DatabaseManager());

		obj.connectingWithSQLDatabaseUsingJDBC();

		addButtonWhichConnectsWithDatabase(addButton);

		ediButtonClicked(firstNameLabel, lastNameLabel, ageLabel, editButton, updateButton);

		updateButtonInsideEditInsertsUpdatedValues(updateButton);

		addingComponentsToFrontPageFrame(firstNameLabel, lastNameLabel, ageLabel, addButton, editButton, readButton);

		frontPageFrameDefaultProperties();

		readButtonClicked();

	}

	private void connectingWithSQLDatabaseUsingJDBC() {
		databaseManager.connectingWithSQLDatabaseUsingJDBC();

	}

	private static void frontPageFrameDefaultProperties() {
		frontPageFrame.pack();
		frontPageFrame.setSize(400, 280);
		frontPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frontPageFrame.setVisible(true);
		frontPageFrame.setBounds(200, 100, 500, 500);
		frontPageFrame.getContentPane().setBackground(new Color(0x9CAFB7));
	}

	private static void addingComponentsToFrontPageFrame(JLabel firstNameLabel, JLabel lastNameLabel, JLabel ageLabel,
			JButton addButton, JButton editButton, JButton readButton) {
		frontPageFrame.getContentPane().add(firstNameLabel);
		frontPageFrame.getContentPane().add(lastNameLabel);
		frontPageFrame.getContentPane().add(ageLabel);
		frontPageFrame.getContentPane().add(firstNameTextField);
		frontPageFrame.getContentPane().add(lastNameTextField);
		frontPageFrame.getContentPane().add(ageTextField);
		frontPageFrame.getContentPane().add(addButton);
		frontPageFrame.getContentPane().add(editButton);
		frontPageFrame.getContentPane().add(readButton);
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
		editButton.setBackground(new Color(0x6457A6));
		editButton.setForeground(new Color(0xFDF0D5));
		editButton.setBorder(BorderFactory.createEtchedBorder());
		editButton.setFocusable(false);
	}

	private static void configureAddButton(JButton addButton) {
		addButton.setText("Add");
		addButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
		addButton.setBackground(new Color(0xFF5A5F));
		addButton.setForeground(new Color(0xFFFFFF));
		addButton.setBorder(BorderFactory.createEtchedBorder());
		addButton.setFocusable(false);
	}

	private static void configureReadButton(JButton readButton) {
		readButton.setText("Read");
		readButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
		readButton.setBackground(new Color(0x247BA0));
		readButton.setForeground(new Color(0xFFFCFF));
		readButton.setBorder(BorderFactory.createEtchedBorder());
		readButton.setFocusable(false);
	}

	private static void ediButtonClicked(JLabel firstNameLabel, JLabel lastNameLabel, JLabel ageLabel, JButton Button2,
			JButton Button3) {
		Button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				UpdateFrame.main(null);

			}

		});
	}

	public static void readButtonClicked() {

		readButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Inside Read button");
				ReadButtonJFrame.main(null);

			}

		});
	}

	public static boolean isRequiredFieldsValidated(String firstName, String lastName, String age) {

		if (firstName.equals("")) {

			if (lastName.equals("")) {

				if (age.equals("")) {

					return false;
				}
			}
			return false;
		}

		else if (age.equals("")) {

			return false;
		}

		else if (lastName.equals("")) {

			if (age.equals("")) {

				return false;
			}

			return false;
		}

		else {

			return true;
		}

	}

	private static void showErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage, "MessageDialog", JOptionPane.ERROR_MESSAGE, null);
	}

	private static void updateButtonInsideEditInsertsUpdatedValues(JButton Button3) {

		Button3.addActionListener(new ActionListener() {
			boolean isValidate;

			@Override
			public void actionPerformed(ActionEvent e) {

				editFramefirstName = firstNameTextField.getText();
				editFrameLastName = lastNameTextField.getText();
				editFrameAge = ageTextField.getText();

				isValidate = isRequiredFieldsValidated(editFramefirstName, editFrameLastName, editFrameAge);

				if (isValidate == false) {
					showErrorMessage("Please Fill the Empty Fields");

				} else {
					query2 = String.format(
							"UPDATE PEOPLE SET first_name= '%s',last_name= '%s',age ='%s' WHERE first_name='%s' ",
							editFramefirstName, editFrameLastName, editFrameAge, editFramefirstName);
					try {

						databaseManager.getStatement().executeUpdate(query2);

					} catch (SQLException e1) {
						System.err.println("Could Not Update Database" + e1.getMessage());
						e1.printStackTrace();
						showErrorMessage("Could Not Update Data Contact Your Administration");
					}

					JOptionPane.showMessageDialog(null, "Values Updated", "Values", JOptionPane.INFORMATION_MESSAGE);

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

			private void validationLogic(JButton Button, ActionEvent e) {

				if ((e.getSource() == Button) == false) {

				}

				else {

					if (isRequiredFieldsValidated(firstNameTextField.getText(), lastNameTextField.getText(),
							ageTextField.getText()))

					{

						query1 = String.format("INSERT INTO PEOPLE VALUES('%s','%s','%s')",
								firstNameTextField.getText(), lastNameTextField.getText(), ageTextField.getText());
						try {
							int updatequery = databaseManager.getStatement().executeUpdate(query1);
							JOptionPane.showMessageDialog(null,
									"Succesfully Inserted " + updatequery + " values in Database");

						} catch (SQLException e1) {

							e1.printStackTrace();
							e1.getMessage();
						}

						firstNameTextField.setText("");
						lastNameTextField.setText("");
						ageTextField.setText("");

					}

					else {
						showErrorMessage("Please Enter Required Field");
					}

				}

			};

		});

	}

}
