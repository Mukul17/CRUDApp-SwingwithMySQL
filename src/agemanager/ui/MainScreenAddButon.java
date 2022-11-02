package agemanager.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import agemanager.domain.PeopleRepository;
import agemanager.domain.ValidationOfFields;

public class MainScreenAddButon {

	protected static void addButtonWhichConnectsWithDatabase(JButton Button) {
		Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				validationLogic(Button, e);
			}

			private void validationLogic(JButton Button, ActionEvent e) {

				if ((e.getSource() == Button) == false) {

				}

				else {

					if (ValidationOfFields.isRequiredFieldsValidated(HomeScreen.firstNameTextField.getText(),
							HomeScreen.lastNameTextField.getText(), HomeScreen.ageTextField.getText(),
							HomeScreen.aadharNumberField.getText())) {

						try {
							PeopleRepository instance = PeopleRepository.getInstance();
							instance.sendQuery();

							JOptionPane.showMessageDialog(null,
									"Succesfully Inserted " + instance.updateResultOfQuery() + " values in Database");

						} catch (SQLException e1) {

							e1.printStackTrace();
							HomeScreen.showErrorMessage(e1.getMessage());

						}

						HomeScreen.firstNameTextField.setText("");
						HomeScreen.lastNameTextField.setText("");
						HomeScreen.ageTextField.setText("");
						HomeScreen.aadharNumberField.setText("");

					}

					else {
						HomeScreen.showErrorMessage("Please Enter Required Field");
					}

				}

			};

		});

	}

	public MainScreenAddButon() {
		super();
	}

}