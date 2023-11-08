package com.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.CustomerProduct;
import com.connection.ConnectionManager;
import com.dao.CustomerDAO;
import com.dao.CustomerDAOImpl;
import com.dao.CustomerProductDAO;
import com.dao.CustomerProductDAOImpl;
import com.dao.ProductDAO;
import com.dao.ProductDAOImpl;
import com.dto.CustomerDTO;
import com.dto.ProductDTO;
import com.sql.SqlScript;
import com.vo.CustomerVO;

public class MainApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = ConnectionManager.getConnection();
		
		//INSERT DI DUE CUSTOMER
		CustomerDTO customerDTO1 = new CustomerDTO("Proto","italy");
		CustomerDTO customerDTO2 = new CustomerDTO("Sestito","italy");
		
		CustomerDAO customerDAO = new CustomerDAOImpl();
		//inserimento primo customer
		customerDAO.addCustomer(SqlScript.sqlCustomerInsert ,con, customerDTO1);
		
		CustomerProductDAO customerProductDAO = new CustomerProductDAOImpl();
		//recupero max(id) primo customer
		int maxCustomerId =customerProductDAO.findMaxId(SqlScript.sqlFindMaxCustomerId, con);
		
		//inseirmento secondo customer
//		customerDAO.addCustomer(SqlScript.sqlCustomerInsert ,con, customerDTO2);
		//non recuperiamo di nuovo il max(id) perchè incrementeremo di uno 1 il MaxCustomerId
		
		//inseirmento di due product
		ProductDTO productDTO1 = new ProductDTO("pc10", "England");
		ProductDTO productDTO2 = new ProductDTO("phone23", "USA");

		
		ProductDAO productDAO = new ProductDAOImpl();
		//inseirmento primo product
		productDAO.addProduct(SqlScript.sqlProductInsert, con, productDTO1);
		//recupero max(id) primo product
		int maxProductId = customerProductDAO.findMaxId(SqlScript.sqlFindMaxProductId, con);
		
		//inserimento secondo product
		productDAO.addProduct(SqlScript.sqlProductInsert, con, productDTO2);
		//non recuperiamo di nuovo il max(id) perchè incrementeremo di uno 1 il MaxProductId
		
		
		//quattro inserimenti nella tabella Join:
		//customer1,product1    (customer1,associato a product1)
		//customer1,product2
		//customer2,product1
		//customer2,product2
		
		CustomerProduct customerProduct1 = new CustomerProduct(maxCustomerId,maxProductId); //1,1
		CustomerProduct customerProduct2 = new CustomerProduct(maxCustomerId,maxProductId + 1); //1,2
		CustomerProduct customerProduct3 = new CustomerProduct(maxCustomerId + 1,maxProductId); // 2,1
		CustomerProduct customerProduct4 = new CustomerProduct(maxCustomerId + 1,maxProductId + 1); //2,2



		
		customerProductDAO.addCustomerProduct(SqlScript.sqlJoinInsert, con, customerProduct1 );
		customerProductDAO.addCustomerProduct(SqlScript.sqlJoinInsert, con, customerProduct2 );
		customerProductDAO.addCustomerProduct(SqlScript.sqlJoinInsert, con, customerProduct3);
		customerProductDAO.addCustomerProduct(SqlScript.sqlJoinInsert, con, customerProduct4);
		
		//TEST RICERCA DEI NOMI CUSTOMER PER PRODOTTO CON id=1
		ArrayList<CustomerVO> customers = customerProductDAO.findCustomersNameByProduct(SqlScript.sqlFindCustomersNameByProduct, con, 1);
		customers.forEach(customerVO->System.out.println(customerVO.getName()));
		




		



		
		
		

	}

}
