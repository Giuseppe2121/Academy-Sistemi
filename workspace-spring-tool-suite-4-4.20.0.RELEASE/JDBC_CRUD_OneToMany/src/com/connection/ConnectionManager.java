package com.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionManager implements ConnectionParameters {
	
	//apertura di una connessione e restituzione della stessa
	

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName(dbDriver);

//		Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

		return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	}
	
	//inizializazione di un oggetto preparedStatement e restituzione dello stesso
	public static PreparedStatement getPreparedStatement(String sql, Connection con) throws ClassNotFoundException, SQLException {
		
		return con.prepareStatement(sql);
		
	}
	
	//inizializzazione di un ResultSet (struttura dati JDBC)
	//gai contenente le informaizoni recuperate dal database
	//rispetto ala query di lettura passata in input al metodo
	public static ResultSet getResultSet(String sql, Connection con) throws SQLException {
		
		return con.createStatement().executeQuery(sql);
	
	}
	
	/*
	 * Chiusura della connessione 
	 */
	public void closeConnection(Connection con) throws SQLException {
		
		con.close();
		
	}

}
