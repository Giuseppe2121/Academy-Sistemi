package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.CustomerProduct;
import com.connection.ConnectionManager;
import com.vo.CustomerVO;


public class CustomerProductDAOImpl implements CustomerProductDAO{
	
	//insert nella tabella Join
	
	@Override
	public void addCustomerProduct(String sql, Connection con, CustomerProduct customerProduct) throws ClassNotFoundException, SQLException {
		
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		//sql = insert into CostumerProduct(costumer_id,product_id) values (?,?)
		ps.setInt(1, customerProduct.getCustomerId());
		ps.setInt(2, customerProduct.getProductId());
		
		ps.executeUpdate();
		
	}
	
	/*
	 * metodo generico in grado di restituire 
	 * il max id di qualsiasi tabella
	 */

	@Override
	public int findMaxId(String sql, Connection con) throws SQLException {
		
		
		ResultSet rs = ConnectionManager.getResultSet(sql,con);
		
		int maxId = 0;
		
		if (rs.next());
		
		maxId = rs.getInt(1);   //ResultSet parte da 1
		
		
		return maxId;	
		
	}

	@Override
	public ArrayList<CustomerVO> findCustomersNameByProduct(String sql, Connection con, int productId) throws ClassNotFoundException, SQLException {
		
		ArrayList<CustomerVO> customers = new ArrayList<>();
		CustomerVO customerVO = null;
		
//		select customer.name from customer left join customer_product 
//		on customer.id=customer_product.customer_id where customer_product.product_id = ?
		
		//il preparedSt. sostituisce al ? della query in input 
		//un elemento cocncreto rappresentato dal productId anch'esso
		//parametro in input al metodo
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		ps.setInt(1, productId);
//		select customer.name from customer left join customer_product 
//		on customer.id=customer_product.customer_id where customer_product.product_id = productId
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			/*
			 * per ogni oggetto torvato nel resultset copiamo il contenuto in 
			 * un oggetto di tipo CustomerVO (perchè Serializable)
			 */
			
			customerVO = new CustomerVO(rs.getString("name"),null,0);
			
			/*
			 * Ogni CostumerVO va inserito 
			 * nella lista
			 */
			
			customers.add(customerVO);
		}
		
		
		return customers;
	}
	
	
}
