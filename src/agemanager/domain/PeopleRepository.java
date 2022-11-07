package agemanager.domain;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import agemanager.database.UpdateQueryHandlerImpl;
import agemanager.ui.HomeScreen;
import agemanager.ui.MainScreenUpdateButton;

public class PeopleRepository extends SendQueryForHomeScreenAddButon {
	String query2;
	static UpdateQueryHandlerImpl handler = new UpdateQueryHandlerImpl();
	private static PeopleRepository instance = new PeopleRepository();

	public void addPerson(Person person) {

	}

	public static PeopleRepository getInstance() {

		if (instance == null) {
			instance = new PeopleRepository();
		}

		return instance;
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

	public int updateResultOfQuery() throws SQLException {
		int updatequery = handler.updateQueriesConnectionHandler(query1);
		return updatequery;
	}

	public String updateQuery() {
		try {
			String query2 = String.format(
					"UPDATE PEOPLE SET first_name= '%s',last_name= '%s',age ='%s', ADHAR_NUM= '%s' WHERE first_name='%s' ",
					MainScreenUpdateButton.editFramefirstName, MainScreenUpdateButton.editFrameLastName,
					MainScreenUpdateButton.editFrameAge, MainScreenUpdateButton.editAadharNumber);
			return query2;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			HomeScreen.showErrorMessage(e.getMessage());
		}
		return query2;

	}

}
