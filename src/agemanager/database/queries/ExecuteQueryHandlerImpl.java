package agemanager.database.queries;

import java.sql.ResultSet;
import java.sql.SQLException;

import agemanager.database.connector.DatabaseConnector;

public class ExecuteQueryHandlerImpl implements IExecuteQuery {
	DatabaseConnector connector = new DatabaseConnector();

	public ExecuteQueryHandlerImpl() {
		super();
	}

	@Override
	public ResultSet executeQueryMethodResultSet(String queryString) throws SQLException {
	
		
	DatabaseConnector.connectingWithSQLDatabaseUsingJDBC();
	
		return DatabaseConnector.getStatement().executeQuery(queryString);
	
	
	}

}