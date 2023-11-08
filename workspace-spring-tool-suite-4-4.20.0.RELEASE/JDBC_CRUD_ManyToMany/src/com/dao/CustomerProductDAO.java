package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.CustomerProduct;
import com.vo.CustomerVO;

public interface CustomerProductDAO {
	
	public void addCustomerProduct(String sql, Connection con, CustomerProduct customerProduct) throws ClassNotFoundException, SQLException;
	
	public int findMaxId(String sql,Connection con) throws SQLException;
	
	public ArrayList<CustomerVO> findCustomersNameByProduct(String sql, Connection con, int productId) throws ClassNotFoundException, SQLException;
	
	
	
	

}
