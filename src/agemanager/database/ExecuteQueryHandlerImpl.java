package agemanager.database;

import java.sql.ResultSet;
import java.sql.SQLException;

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