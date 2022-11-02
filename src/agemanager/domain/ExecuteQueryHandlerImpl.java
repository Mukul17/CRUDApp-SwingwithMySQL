package agemanager.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQueryHandlerImpl implements IExecuteQuery {

	public ExecuteQueryHandlerImpl() {
		super();
	}

	@Override
	public ResultSet executeQueryMethodResultSet(String queryString) throws SQLException {
	
		String url = "jdbc:mysql://localhost:3306/Dog";
		String pass = "Mukul1771@";
		String userName = "root";
		Connection connection = DriverManager.getConnection(url, userName, pass);
	
		Statement statement = connection.createStatement();
		return statement.executeQuery(queryString);
	
	}

}