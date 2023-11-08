package com.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// il metodo static non può essere applicato ai metodi delle interfacce
public interface ConnectionManagerI {

	public Connection getConnection() throws ClassNotFoundException, SQLException;

	public PreparedStatement getPreparedStatement(String sql, Connection con) throws ClassNotFoundException, SQLException;
	
	public ResultSet getResultSet(String sql, Connection con) throws SQLException;
	
	public void closeConnection(Connection con) throws SQLException;
}
