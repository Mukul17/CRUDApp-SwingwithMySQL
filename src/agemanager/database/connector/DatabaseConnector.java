package agemanager.database.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnector {

	private static Statement statement;
	private static Connection connection;

	
	public static Statement getStatement() {
		return statement;
	}


	public static void setStatement(Statement statement) {
		DatabaseConnector.statement = statement;
	}


	public static Connection getConnection() {
		return connection;
	}


	public static void setConnection(Connection connection) {
		DatabaseConnector.connection = connection;
	}


	public static void connectingWithSQLDatabaseUsingJDBC() {
		try {

			String url = "jdbc:mysql://localhost:3306/Dog";
			String username = "root";
			String pass = "Mukul1771@";
			connection = DriverManager.getConnection(url, username, pass);

			if (connection.isClosed()) {
				System.out.println("Connection is closed");
			} else {
				System.out.println("Connection is established");
			}

			String q = "Select * from people";

			statement = connection.createStatement();
			statement.executeQuery(q);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
