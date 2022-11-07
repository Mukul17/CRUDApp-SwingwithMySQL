package agemanager.database;

import java.sql.SQLException;

public interface IQueryHandler {

	int updateQueriesConnectionHandler(String queryString) throws SQLException;

}