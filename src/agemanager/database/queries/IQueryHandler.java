package agemanager.database.queries;

import java.sql.SQLException;

public interface IQueryHandler {

	int updateQueriesConnectionHandler(String queryString) throws SQLException;

}