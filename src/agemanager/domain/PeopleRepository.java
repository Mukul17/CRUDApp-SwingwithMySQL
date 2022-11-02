package agemanager.domain;

import java.sql.SQLException;

import agemanager.ui.HomeScreen;
import agemanager.ui.MainScreenUpdateButton;

public class PeopleRepository {
	String query1, query2;
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

	public String sendQuery() throws SQLException {
		query1 = String.format("INSERT INTO PEOPLE VALUES('%s','%s','%s','%s')",
				HomeScreen.firstNameTextField.getText(), HomeScreen.lastNameTextField.getText(),
				HomeScreen.ageTextField.getText(), HomeScreen.aadharNumberField.getText());
		return query1;
	}

	public int updateResultOfQuery() throws SQLException {
		int updatequery = handler.updateQueriesHandler(query1);
		return updatequery;
	}

	public String updateQuery() throws SQLException {
		String query2 = String.format(
				"UPDATE PEOPLE SET first_name= '%s',last_name= '%s',age ='%s', ADHAR_NUM= '%s' WHERE first_name='%s' ",
				MainScreenUpdateButton.editFramefirstName, MainScreenUpdateButton.editFrameLastName,
				MainScreenUpdateButton.editFrameAge, MainScreenUpdateButton.editAadharNumber);
		return query2;
	}

}
