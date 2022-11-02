package databasefacade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnector {

	private static Statement statement;
	private static Connection connection;

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
