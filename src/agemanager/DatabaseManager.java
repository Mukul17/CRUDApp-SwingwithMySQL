package agemanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseManager {

	private Statement statement;
	private Connection connection;

	
	
	
	public DatabaseManager() {
		System.out.println("Database Manager Object is Created");
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public void connectingWithSQLDatabaseUsingJDBC() {
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
