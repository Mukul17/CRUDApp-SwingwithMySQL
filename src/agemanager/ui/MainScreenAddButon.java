package agemanager.ui;

import java.awt.HeadlessException;
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
				try {
					validationLogic(Button, e);
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			private void validationLogic(JButton Button, ActionEvent e) throws HeadlessException, SQLException {

				if ((e.getSource() == Button) == false) {

				}

				else {

					if (ValidationOfFields.isRequiredFieldsValidated(HomeScreen.firstNameTextField.getText(),
							HomeScreen.lastNameTextField.getText(), HomeScreen.ageTextField.getText(),
							HomeScreen.aadharNumberField.getText())) {

						addButton();

						settingFieldsToBlank();

					}

					else {
						HomeScreen.showErrorMessage("Please Enter Required Field");
					}

				}

			}

			private void settingFieldsToBlank() {
				HomeScreen.firstNameTextField.setText("");
				HomeScreen.lastNameTextField.setText("");
				HomeScreen.ageTextField.setText("");
				HomeScreen.aadharNumberField.setText("");
			}

			private void addButton() {
				PeopleRepository instance = PeopleRepository.getInstance();
				instance.sendQuery();

				try {
					JOptionPane.showMessageDialog(null,
							"Succesfully Inserted " + instance.updateResultOfQuery() + " values in Database");
				} catch (HeadlessException e) {
					JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
					e.printStackTrace();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}
			};

		});

	}

	public MainScreenAddButon() {
		super();
	}

}