package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connection.ConnectionManager;
import com.dto.CustomerDTO;

public class CustomerDAOImpl implements CustomerDAO {   //implenets CustomerDAO che crea automaticamente l'interfaccia DAO
	
	@Override
	public void addCustomer(String sql, Connection con, CustomerDTO customerDTO) throws ClassNotFoundException, SQLException {
		
		
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		//sql = insert into costumer (name,country) values (?,?)
		ps.setString(1, customerDTO.getName());
		ps.setString(2, customerDTO.getCountry());
		
		ps.executeUpdate();
}
	
	
	
	
	
	

}
