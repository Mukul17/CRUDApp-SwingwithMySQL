package agemanager;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class ReadFromDataBase implements IReadDatabase {
	public JPanel contentPane;
	public JTable table;
	public DefaultTableModel defaultTableModel;
	public String firstName;
	public String lastName;
	public String age;
	public String aadharNumber;
	public String selectQuery;
	public ResultSet resultSet;
	public ResultSetMetaData resultSetMetaData;

	public ReadFromDataBase() {
	}

	@Override
	public void readingDatabase(JScrollPane scrollPane) throws SQLException  {
		ExecuteQueryHandlerImpl executeQueryHandlerImpl = new ExecuteQueryHandlerImpl() ;
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			table.setFillsViewportHeight(true);
			table.setForeground(new Color(0x0F0A0A));
			table.setColumnSelectionAllowed(true);
			table.setCellSelectionEnabled(true);
			table.setBorder(new CompoundBorder());
			table.setBackground(new Color(100, 149, 237));

			selectQuery = "SELECT DISTINCT * FROM PEOPLE";

			DatabaseManager.connectingWithSQLDatabaseUsingJDBC();

			
			resultSet = executeQueryHandlerImpl.executeQueryMethodResultSet(selectQuery);

			defaultTableModel = new DefaultTableModel();

			defaultTableModel = (DefaultTableModel) table.getModel();

			resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();

			int cols = resultSetMetaData.getColumnCount();

			String[] colName = new String[cols];
			for (int i = 0; i < cols; i++) {
				colName[i] = resultSetMetaData.getColumnName(i + 1);

			}
			defaultTableModel.setColumnIdentifiers(colName);
			table.getTableHeader().setFont(new Font("Segoe UI", 1, 14));

			while (resultSet.next()) {
				firstName = resultSet.getString(1);
				lastName = resultSet.getString(2);
				age = resultSet.getString(3);
				aadharNumber = resultSet.getString(4);

				String[] rowDataStrings = { firstName, lastName, age, aadharNumber };
				defaultTableModel.addRow(rowDataStrings);
			}
		}


		
		
	
}