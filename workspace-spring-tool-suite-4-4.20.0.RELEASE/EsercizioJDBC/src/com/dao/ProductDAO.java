package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.ProductDTO;
import com.vo.ProductVO;

public interface ProductDAO {
	
	public void addProduct(String sql, Connection con, ProductDTO productDTO) throws ClassNotFoundException, SQLException;
	
	public ArrayList<ProductVO> productFilter (String sql, Connection con, String name) throws ClassNotFoundException, SQLException;
	
	

}
