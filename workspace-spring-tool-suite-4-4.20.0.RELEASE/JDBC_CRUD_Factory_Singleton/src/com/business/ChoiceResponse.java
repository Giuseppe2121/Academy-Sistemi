package com.business;

import java.sql.SQLException;
import java.util.ArrayList;

import com.enumeration.Choice;
import com.singleton.DAOSingleton;

public class ChoiceResponse implements ChoiceResponseI {
	
	
    @Override
	public ArrayList<Object> choiceRepsonse(Choice choice) throws ClassNotFoundException, SQLException {
		
		
		ArrayList<Object> objects = new ArrayList<>();

		switch (choice) {

		case PRODUCT:
			// find All products sulla tabella product

			objects =DAOSingleton.getProductDAOInstance().findAllProducts(DAOSingleton.getSingletonConnection());

			break;

		case CUSTOMER:
			// find All customer sulla tabella product

			objects =DAOSingleton.getCustomerDAOInstance().findAllCustomers(DAOSingleton.getSingletonConnection());

			break;

		}
		return objects;

	}

}
