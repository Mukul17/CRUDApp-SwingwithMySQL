package agemanager;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class ReadButtonJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel defaultTableModel;
	private String firstName;
	private String lastName;
	private String age;
	private static DatabaseManager databaseManager;

	private String readQueryString;
	private ResultSet resultSet;
	private ResultSetMetaData resultSetMetaData;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					ReadButtonJFrame frame = new ReadButtonJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}

	public ReadButtonJFrame() throws SQLException {

		databaseManager = new DatabaseManager();
		setTitle("Database Data");
		setAlwaysOnTop(true);

		setBounds(100, 100, 512, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 42, 427, 314);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		table.setFillsViewportHeight(true);
		table.setForeground(new Color(0x0F0A0A));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new CompoundBorder());
		table.setBackground(new Color(100, 149, 237));

		readQueryString = "SELECT * FROM PEOPLE";

		databaseManager.connectingWithSQLDatabaseUsingJDBC();

		resultSet = databaseManager.getStatement().executeQuery(readQueryString);

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
			String[] rowDataStrings = { firstName, lastName, age };
			defaultTableModel.addRow(rowDataStrings);
		}

	}

}
