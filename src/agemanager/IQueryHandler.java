package agemanager;

import java.sql.SQLException;

public interface IQueryHandler {

	int updateQueriesHandler(String queryString) throws SQLException;

}