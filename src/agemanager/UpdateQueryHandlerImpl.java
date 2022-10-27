package agemanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class UpdateQueryHandlerImpl implements IQueryHandler {

	public UpdateQueryHandlerImpl() {
		super();
	}

	@Override
	public int updateQueriesHandler(String queryString) throws SQLException {
	
		String url = "jdbc:mysql://localhost:3306/Dog";
		String pass = "Mukul1771@";
		String userName = "root";
		
		Connection connection = DriverManager.getConnection(url, userName, pass);
		
			if (connection.isClosed()) {
				System.out.println("Connection is Closed");
				JOptionPane.showMessageDialog(null, "Connection to the Database is Failed....Check with Database Admin");
				return 0;
			}
			else {
				Statement statement = connection.createStatement();
				int executeUpdate = statement.executeUpdate(queryString);
				JOptionPane.showMessageDialog(null, "Updation Sucessfull!!");
				return executeUpdate;
			}
		
		
	}

}