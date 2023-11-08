package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public interface CustomerDAO {
	
	public ArrayList<Object> findAllCustomers(Connection con) throws SQLException; 

}
