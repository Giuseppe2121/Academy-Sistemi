package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO {

	public ArrayList<Object> findAllProducts(Connection con) throws SQLException;

}
