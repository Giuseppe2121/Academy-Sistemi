package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.dto.CustomerDTO;

public interface CustomerDAO {

	public void addCustomer(String sql, Connection con, CustomerDTO customerDTO) throws ClassNotFoundException, SQLException;

}
