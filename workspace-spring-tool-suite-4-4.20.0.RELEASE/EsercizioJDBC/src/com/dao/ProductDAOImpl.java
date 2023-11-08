package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManager;
import com.dto.ProductDTO;
import com.vo.ProductVO;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public void addProduct(String sql, Connection con, ProductDTO productDTO) throws ClassNotFoundException, SQLException {
		
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		//sql = insert into product (name,origin) values (?,?)

		ps.setString(1, productDTO.getName());
		ps.setString(2, productDTO.getOrigin());
		
		ps.executeUpdate();
		
	}

	@Override
	public ArrayList<ProductVO> productFilter(String sql, Connection con, String name) throws ClassNotFoundException, SQLException {
		
		ArrayList<ProductVO> products = new ArrayList<>();
		
		ProductVO productVO = null;
		
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		ps.setString(1,name);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			productVO = new ProductVO(rs.getString("name"), null, 0);
			
			products.add(productVO);
			
			
		}
	
		return products;
		
	}

}
