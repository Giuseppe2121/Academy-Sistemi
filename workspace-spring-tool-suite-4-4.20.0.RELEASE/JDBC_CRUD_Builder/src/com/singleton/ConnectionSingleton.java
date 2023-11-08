package com.singleton;

import java.sql.Connection;
import java.sql.SQLException;

import com.connection.ConnectionManager;

public class ConnectionSingleton {

	private static Connection con = null;

	public static Connection getSingletonConnection() throws ClassNotFoundException, SQLException {

		if (con == null) {
			con = ConnectionManager.getConnection();
		}
		return con;
	}

}
