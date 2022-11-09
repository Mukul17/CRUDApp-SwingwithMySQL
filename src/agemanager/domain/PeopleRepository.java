package agemanager.domain;

import java.sql.SQLException;

import agemanager.database.update.UpdateButtonInsideEditQuery;
import agemanager.database.update.UpdateQueryHandlerImpl;
import agemanager.ui.HomeScreen;

public class PeopleRepository extends UpdateButtonInsideEditQuery {
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

}
