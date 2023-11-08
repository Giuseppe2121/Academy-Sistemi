package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.connection.ConnectionManager;
import com.sql.SqlScript;

import com.vo.ProductVO;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public ArrayList<Object> findAllProducts(Connection con) throws SQLException {

		ArrayList<Object> products = new ArrayList<>();

		ProductVO productVO = null;

		ResultSet rs = ConnectionManager.getResultSet(SqlScript.sqlProducts, con);

		while (rs.next()) {

			productVO = new ProductVO(rs.getString("name"), rs.getString("origin"), rs.getInt("id"));

			products.add(productVO);

		}

		return products;

	}

}
