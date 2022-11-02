package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import crudmanager.HomeScreen;
import crudmanager.UpdateQueryHandlerImpl;
import crudmanager.ValidationOfFields;

public class MainScreenAddButon {
	static ValidationOfFields ageManager = new HomeScreen();
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
	
					if (HomeScreen.isRequiredFieldsValidated( HomeScreen.firstNameTextField.getText(), HomeScreen.lastNameTextField.getText(),
							HomeScreen.ageTextField.getText(), HomeScreen.aadharNumberField.getText()))
					{
	
						try {
							String query1 = String.format("INSERT INTO PEOPLE VALUES('%s','%s','%s','%s')",
									HomeScreen.firstNameTextField.getText(), HomeScreen.lastNameTextField.getText(), HomeScreen.ageTextField.getText(),
									HomeScreen.aadharNumberField.getText());
							
							int updatequery =  handler.updateQueriesHandler(query1);
							
							JOptionPane.showMessageDialog(null,
									"Succesfully Inserted " + updatequery + " values in Database");
	
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