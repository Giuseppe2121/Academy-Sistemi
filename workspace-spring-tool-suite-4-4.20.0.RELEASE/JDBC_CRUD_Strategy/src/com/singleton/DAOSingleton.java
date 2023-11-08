package com.singleton;

import java.sql.Connection;
import java.sql.SQLException;

import com.connection.ConnectionManager;
import com.dao.CustomerDAO;
import com.dao.CustomerDAOImpl;
import com.dao.ProductDAO;
import com.dao.ProductDAOImpl;

public class DAOSingleton {

	// Unica istanza della classe
	private static CustomerDAO customerDAO = null;

	private static ProductDAO productDAO = null;
	
	private static Connection con;

	public static CustomerDAO getCustomerDAOInstance() {
		// Crea l'oggetto solo se NON esiste:
		if (customerDAO == null) {
			customerDAO = new CustomerDAOImpl();
		}
		return customerDAO;
	}

	public static ProductDAO getProductDAOInstance() {
		// Crea l'oggetto solo se NON esiste:
		if (productDAO == null) {
			productDAO = new ProductDAOImpl();
		}
		return productDAO;
	}
	
	public static Connection getSingletonConnection() throws ClassNotFoundException, SQLException {
		// Crea l'oggetto solo se NON esiste:
		if (con == null) {
			con = ConnectionManager.getConnection();
		}
		return con;
	}

}
