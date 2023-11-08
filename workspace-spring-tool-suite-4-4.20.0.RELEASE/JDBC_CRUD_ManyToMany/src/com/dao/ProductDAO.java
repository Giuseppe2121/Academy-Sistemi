package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.dto.ProductDTO;



public interface ProductDAO {
	
	
	public void addProduct(String sql, Connection con, ProductDTO productDTO) throws ClassNotFoundException, SQLException;

	
	
	

}
