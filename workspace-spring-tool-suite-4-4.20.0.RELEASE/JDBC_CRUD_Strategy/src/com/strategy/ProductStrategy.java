package com.strategy;

import java.sql.SQLException;
import java.util.ArrayList;

import com.singleton.DAOSingleton;

public class ProductStrategy implements Strategy {

	@Override
	public ArrayList<Object> findAllObjects() throws ClassNotFoundException, SQLException {
		
		
		return DAOSingleton.getProductDAOInstance().findAllProducts(DAOSingleton.getSingletonConnection());
	}
	
	

}
