package com.singleton;

import java.sql.Connection;
import java.sql.SQLException;
import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;

public class DAOSingleton {

	private static Connection con = null;
	private static StudentDAO studentDAO = null;

	public static StudentDAO getStudentDAOInstance() {
		// Crea l'oggetto solo se NON esiste:
		if (studentDAO == null) {
			studentDAO = new StudentDAOImpl();
		}
		return studentDAO;
	}

	public static Connection getSingletonConnection() throws ClassNotFoundException, SQLException {
		if (con == null) {            // "||" significa or
			con = ConnectionManager.getConnection();
		}
		return con;
	}

}
