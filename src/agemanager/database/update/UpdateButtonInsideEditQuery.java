package agemanager.database.update;

import agemanager.database.queries.SendQueryForHomeScreenAddButon;
import agemanager.ui.HomeScreen;
import agemanager.ui.MainScreenUpdateButton;

public class UpdateButtonInsideEditQuery extends SendQueryForHomeScreenAddButon {

	String query2;

	public UpdateButtonInsideEditQuery() {
		super();
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