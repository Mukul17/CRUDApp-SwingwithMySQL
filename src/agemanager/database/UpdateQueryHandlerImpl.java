package agemanager.database;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UpdateQueryHandlerImpl implements IQueryHandler {
	DatabaseConnector connector = new DatabaseConnector();

	public UpdateQueryHandlerImpl() {
		super();
	}

	@Override
	public int updateQueriesConnectionHandler(String queryString) throws SQLException {

		DatabaseConnector.connectingWithSQLDatabaseUsingJDBC();

		int executeUpdate = DatabaseConnector.getStatement().executeUpdate(queryString);
		JOptionPane.showMessageDialog(null, "Updation Sucessfull!!");
		return executeUpdate;
	}

}
