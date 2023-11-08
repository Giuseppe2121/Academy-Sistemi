package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connection.ConnectionManager;
import com.dto.ProductDTO;

public class ProductDAOImpl implements ProductDAO{

	@Override
	public void addProduct(String sql, Connection con, ProductDTO productDTO) throws ClassNotFoundException, SQLException {
		
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		//sql = insert into product (name,origin) values (?,?)
		ps.setString(1, productDTO.getName());
		ps.setString(2, productDTO.getOrigin());
		
		ps.executeUpdate();		
		
	}

	
	

}
