package com.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManager;
import com.dao.ProductDAO;
import com.dao.ProductDAOImpl;
import com.dto.ProductDTO;
import com.sql.SqlScript;
import com.vo.ProductVO;

public class MainApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = ConnectionManager.getConnection();
		
		ProductDTO productDTO01 = new ProductDTO("iphone", "Irland");
		ProductDTO productDTO02 = new ProductDTO("smartphone", "Canada");
		ProductDTO productDTO03 = new ProductDTO("rogphone", "Francia");
		
		ProductDAO productDAO = new ProductDAOImpl();
		
		productDAO.addProduct(SqlScript.sqlProductInsert, con, productDTO01);
		productDAO.addProduct(SqlScript.sqlProductInsert, con, productDTO02);
		productDAO.addProduct(SqlScript.sqlProductInsert, con, productDTO03);
		
		
		ArrayList<ProductVO> products = productDAO.productFilter(SqlScript.sqlProductFilter, con, "%phone%");
		products.forEach(prodotto->System.out.println(prodotto.getName()));
		





	}

}
