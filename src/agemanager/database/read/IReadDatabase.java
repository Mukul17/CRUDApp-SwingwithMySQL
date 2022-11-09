package agemanager.database.read;

import java.sql.SQLException;

import javax.swing.JScrollPane;

public interface IReadDatabase {

	void readingDatabase(JScrollPane scrollPane) throws SQLException;
}