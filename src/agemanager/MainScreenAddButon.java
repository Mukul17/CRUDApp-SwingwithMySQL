package agemanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MainScreenAddButon {
	static ValidationOfFields ageManager = new AgeManager();
	static UpdateQueryHandlerImpl handler = new UpdateQueryHandlerImpl();

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
	
					if (AgeManager.isRequiredFieldsValidated( AgeManager.firstNameTextField.getText(), AgeManager.lastNameTextField.getText(),
							AgeManager.ageTextField.getText(), AgeManager.aadharNumberField.getText()))
					{
	
						try {
							String query1 = String.format("INSERT INTO PEOPLE VALUES('%s','%s','%s','%s')",
									AgeManager.firstNameTextField.getText(), AgeManager.lastNameTextField.getText(), AgeManager.ageTextField.getText(),
									AgeManager.aadharNumberField.getText());
							
							int updatequery =  handler.updateQueriesHandler(query1);
							
							JOptionPane.showMessageDialog(null,
									"Succesfully Inserted " + updatequery + " values in Database");
	
						} catch (SQLException e1) {
	
							e1.printStackTrace();
							AgeManager.showErrorMessage(e1.getMessage());
	
						}
	
						AgeManager.firstNameTextField.setText("");
						AgeManager.lastNameTextField.setText("");
						AgeManager.ageTextField.setText("");
						AgeManager.aadharNumberField.setText("");
	
					}
	
					else {
						AgeManager.showErrorMessage("Please Enter Required Field");
					}
	
				}
	
			};
	
		});
	
	}

	public MainScreenAddButon() {
		super();
	}

}