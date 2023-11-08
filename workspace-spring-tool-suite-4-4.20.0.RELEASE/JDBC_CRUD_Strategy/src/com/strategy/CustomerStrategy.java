package com.strategy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.CustomerDAO;
import com.singleton.DAOSingleton;

public class CustomerStrategy implements Strategy {
	

	@Override
	public ArrayList<Object> findAllObjects() throws ClassNotFoundException, SQLException {    //findAllObjects sarebbe findAllCustomers
		
		Connection con = DAOSingleton.getSingletonConnection();
		
		CustomerDAO customerDAO = DAOSingleton.getCustomerDAOInstance();
		
		return customerDAO.findAllCustomers(con);
		
		//volendo avremmo potuto fare anche in questa maniera
		//return DAOSingleton.getCustomerDAOIstance().findAllCustomers(DAOSingleton.getSingletonConnection());
	}
	

}
