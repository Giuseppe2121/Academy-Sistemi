package com.strategy;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Strategy {
	
	public ArrayList<Object> findAllObjects() throws ClassNotFoundException, SQLException;   //object perche padre sia di customer che di product
	

}
