package agemanager.domain;

import agemanager.ui.HomeScreen;

public class SendQueryForHomeScreenAddButon {

	protected String query1;

	public SendQueryForHomeScreenAddButon() {
		super();

	}

	public String sendQuery() {
		try {
			query1 = String.format("INSERT INTO PEOPLE VALUES('%s','%s','%s','%s')",
					HomeScreen.firstNameTextField.getText(), HomeScreen.lastNameTextField.getText(),
					HomeScreen.ageTextField.getText(), HomeScreen.aadharNumberField.getText());
			return query1;

		} catch (Exception e) {
			System.out.println(e.getMessage());

			HomeScreen.showErrorMessage(e.getMessage());
		}
		return query1;
	}

}