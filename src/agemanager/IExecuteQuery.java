package agemanager;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IExecuteQuery {

	ResultSet executeQueryMethodResultSet(String queryString) throws SQLException;

}