package agemanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MainScreenUpdateButton extends MainScreenAddButon {
	static ValidationOfFields ageManager = new AgeManager();

	protected static void updateButtonInsideEditInsertsUpdatedValues(JButton Button3) {
	
		Button3.addActionListener(new ActionListener() {
			boolean isValidate;
	
			@Override
			public void actionPerformed(ActionEvent e) {

				
				String editFramefirstName = AgeManager.firstNameTextField.getText();
				String editFrameLastName = AgeManager.lastNameTextField.getText();
				String editFrameAge = AgeManager.ageTextField.getText();
				String editAadharNumber = AgeManager.aadharNumberField.getText();
	
				isValidate =  AgeManager.isRequiredFieldsValidated(editFramefirstName, editFrameLastName, editFrameAge,
						editAadharNumber);
	
				if (isValidate == false) {
					AgeManager.showErrorMessage("Please Fill the Empty Fields");
	
				} else {
					String query2 = String.format(
							"UPDATE PEOPLE SET first_name= '%s',last_name= '%s',age ='%s', ADHAR_NUM= '%s' WHERE first_name='%s' ",
							editFramefirstName, editFrameLastName, editFrameAge, editAadharNumber);
					try {
						handler.updateQueriesHandler(query2);
	
					} catch (SQLException e1) {
						System.err.println("Could Not Update Database" + e1.getMessage());
						e1.printStackTrace();
						AgeManager.showErrorMessage("Could Not Update Data Contact Your Administration");
					}
	
					JOptionPane.showMessageDialog(null, "Values Updated", "Values", JOptionPane.INFORMATION_MESSAGE);
	
				AgeManager.firstNameTextField.setText("");
				AgeManager.lastNameTextField.setText("");
				AgeManager.ageTextField.setText("");
				AgeManager.aadharNumberField.setText("");
				}
	
			}
		});
	}

	public MainScreenUpdateButton() {
		super();
	}

}