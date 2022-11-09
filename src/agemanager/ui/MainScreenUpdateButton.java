package agemanager.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import agemanager.database.update.UpdateButtonInsideEditQuery;
import agemanager.database.update.UpdateQueryHandlerImpl;
import agemanager.domain.PeopleRepository;
import agemanager.domain.validationoffields.ValidationOfFields;

public class MainScreenUpdateButton extends MainScreenAddButon {
	static UpdateQueryHandlerImpl handler = new UpdateQueryHandlerImpl();
	public static String editFramefirstName, editFrameLastName, editFrameAge, editAadharNumber;
	static UpdateButtonInsideEditQuery instance = PeopleRepository.getInstance();

	protected static void updateButtonInsideEditInsertsUpdatedValues(JButton Button3) {

		Button3.addActionListener(new ActionListener() {
			boolean isValidate;

			@Override
			public void actionPerformed(ActionEvent e) {

				editFramefirstName = HomeScreen.firstNameTextField.getText();
				editFrameLastName = HomeScreen.lastNameTextField.getText();
				editFrameAge = HomeScreen.ageTextField.getText();
				editAadharNumber = HomeScreen.aadharNumberField.getText();

				isValidate = ValidationOfFields.isRequiredFieldsValidated(editFramefirstName, editFrameLastName,
						editFrameAge, editAadharNumber);

				if (isValidate == false) {
					HomeScreen.showErrorMessage("Please Fill the Empty Fields");

				} else {

					try {
						String updateQuery = instance.updateQuery();
						handler.updateQueriesConnectionHandler(updateQuery);

					} catch (SQLException e1) {
						System.err.println("Could Not Update Database" + e1.getMessage());
						e1.printStackTrace();
						HomeScreen.showErrorMessage("Could Not Update Data Contact Your Administration");
					}

					JOptionPane.showMessageDialog(null, "Values Updated", "Values", JOptionPane.INFORMATION_MESSAGE);

					HomeScreen.firstNameTextField.setText("");
					HomeScreen.lastNameTextField.setText("");
					HomeScreen.ageTextField.setText("");
					HomeScreen.aadharNumberField.setText("");
				}

			}
		});
	}

	public MainScreenUpdateButton() {
		super();
	}

}