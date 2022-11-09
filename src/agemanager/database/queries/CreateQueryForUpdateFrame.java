package agemanager.database.queries;

import java.sql.ResultSet;
import java.sql.SQLException;

import agemanager.domain.SearchButtonInUpdate;
import agemanager.domain.UpdateFrame;
import agemanager.ui.CancelButtonInUpdate;
import agemanager.ui.HomeScreen;

public class CreateQueryForUpdateFrame implements ICreateQueryForUpdateFrame {

	@Override
	public boolean createQuery(String aadharNumber) {
		boolean isAdharNumberCorrect = false;

		String queryString = String.format("SELECT * FROM PEOPLE WHERE adhar_num ='%s' ",
				SearchButtonInUpdate.aadharNumString);

		try {

			IExecuteQuery handlerImpl = new ExecuteQueryHandlerImpl();
			ResultSet executeQueryResultSet = handlerImpl.executeQueryMethodResultSet(queryString);

			while (executeQueryResultSet.next()) {

				CancelButtonInUpdate.firstNameTextField.setText(executeQueryResultSet.getString("first_name"));
				CancelButtonInUpdate.lastNameTextField.setText(executeQueryResultSet.getString("last_name"));
				CancelButtonInUpdate.ageTextField.setText(executeQueryResultSet.getString("age"));
				UpdateFrame.checkingIfTextFieldsAreClicked(CancelButtonInUpdate.firstNameTextField);
				UpdateFrame.checkingIfTextFieldsAreClicked(CancelButtonInUpdate.lastNameTextField);
				UpdateFrame.checkingIfTextFieldsAreClicked(CancelButtonInUpdate.ageTextField);
				isAdharNumberCorrect = true;
			}

		} catch (SQLException e) {
			HomeScreen.showErrorMessage(e.getMessage());
			e.printStackTrace();
		}
		return isAdharNumberCorrect;

	}

}
