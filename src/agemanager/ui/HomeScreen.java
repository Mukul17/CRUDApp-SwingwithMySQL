package agemanager.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import agemanager.database.update.UpdateQueryHandlerImpl;
import agemanager.domain.validationoffields.ValidationOfFields;

public class HomeScreen extends ValidationOfFields {

	static String editFramefirstName;
	static String editFrameLastName;
	static String query1;
	static String query2;
	static String editFrameAge;
	static String editAadharNumber;

	static UpdateQueryHandlerImpl handler = new UpdateQueryHandlerImpl();

	public static JTextField firstNameTextField = new JTextField();
	public static JTextField lastNameTextField = new JTextField();
	public static JTextField ageTextField = new JTextField();
	public static JTextField aadharNumberField = new JTextField();
	private static JFrame frontPageFrame;

	public static JButton readButton;
	static JButton addButton;
	static JButton editButton;
	static JButton updateButton;

	public HomeScreen() {
		super();

	}

	public static void main(String[] args) {

		frontPageFrame = new JFrame("Database");
		frontPageFrame.getContentPane().setLayout(null);
		frontPageFrame.setForeground(new Color(0x312509));

		JLabel firstNameLabel = new JLabel("First Name");
		JLabel lastNameLabel = new JLabel("Last Name");
		JLabel ageLabel = new JLabel("Age");
		JLabel aadharNumberLabel = new JLabel("Aadhar Number");

		HomeScreen.settingLabelsBoundsAndFonts(firstNameLabel, lastNameLabel, ageLabel, aadharNumberLabel);

		addButton = new JButton();
		editButton = new JButton();
		updateButton = new JButton();
		readButton = new JButton();

		HomeScreen.settingTextFieldsBoundsAndFonts();

		addButton.setBounds(50, 300, 100, 50);
		editButton.setBounds(180, 300, 100, 50);
		updateButton.setBounds(90, 300, 200, 50);
		readButton.setBounds(300, 300, 100, 50);

		HomeScreen.configureAddButton(addButton);

		HomeScreen.configureEditButton(editButton);

		HomeScreen.configureUpdateButton(updateButton);

		HomeScreen.configureReadButton(readButton);

		

		MainScreenAddButon.addButtonWhichConnectsWithDatabase(addButton);

		MainScreenEditButton.ediButtonClicked(firstNameLabel, lastNameLabel, ageLabel, editButton, updateButton);

		MainScreenUpdateButton.updateButtonInsideEditInsertsUpdatedValues(updateButton);

		HomeScreen.addingComponentsToFrontPageFrame(firstNameLabel, lastNameLabel, ageLabel, aadharNumberLabel,
				addButton, editButton, readButton);

		HomeScreen.frontPageFrameDefaultProperties();

		MainScreenReadButton.readButtonClicked();

	}

	private static void frontPageFrameDefaultProperties() {
		frontPageFrame.pack();
		frontPageFrame.setSize(136, 269);
		frontPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frontPageFrame.setVisible(true);
		frontPageFrame.setBounds(200, 100, 500, 500);
		frontPageFrame.getContentPane().setBackground(new Color(0x9CAFB7));
	}

	private static void addingComponentsToFrontPageFrame(JLabel firstNameLabel, JLabel lastNameLabel, JLabel ageLabel,
			JLabel aadharNumberLabel, JButton addButton, JButton editButton, JButton readButton) {
		frontPageFrame.getContentPane().add(firstNameLabel);
		frontPageFrame.getContentPane().add(lastNameLabel);
		frontPageFrame.getContentPane().add(ageLabel);
		frontPageFrame.getContentPane().add(aadharNumberLabel);
		frontPageFrame.getContentPane().add(firstNameTextField);
		frontPageFrame.getContentPane().add(lastNameTextField);
		frontPageFrame.getContentPane().add(ageTextField);
		frontPageFrame.getContentPane().add(aadharNumberField);
		frontPageFrame.getContentPane().add(addButton);
		frontPageFrame.getContentPane().add(editButton);
		frontPageFrame.getContentPane().add(readButton);
	}

	private static void settingLabelsBoundsAndFonts(JLabel firstNameLabel, JLabel lastNameLabel, JLabel ageLabel,
			JLabel aadharNumberLabel) {
		firstNameLabel.setForeground(new Color(0x0E3B43));
		firstNameLabel.setBounds(20, 60, 120, 120);

		lastNameLabel.setForeground(new Color(0x0E3B43));
		lastNameLabel.setBounds(20, 110, 120, 120);

		ageLabel.setForeground(new Color(0x0E3B43));
		ageLabel.setBounds(20, 150, 70, 120);

		aadharNumberLabel.setForeground(new Color(0x0E3B43));
		aadharNumberLabel.setBounds(12, 200, 120, 120);
	}

	private static void settingTextFieldsBoundsAndFonts() {
		firstNameTextField.setBounds(100, 100, 200, 30);
		firstNameTextField.setFont(new Font("SansSerif", Font.PLAIN, 20));

		lastNameTextField.setBounds(100, 150, 200, 30);
		lastNameTextField.setFont(new Font("SansSerif", Font.PLAIN, 20));

		ageTextField.setBounds(100, 200, 50, 30);
		ageTextField.setFont(new Font("SansSerif", Font.PLAIN, 20));

		aadharNumberField.setBounds(100, 250, 200, 30);
		aadharNumberField.setFont(new Font("SansSerif", Font.PLAIN, 20));
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

	public static void showErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage);
	}

}
