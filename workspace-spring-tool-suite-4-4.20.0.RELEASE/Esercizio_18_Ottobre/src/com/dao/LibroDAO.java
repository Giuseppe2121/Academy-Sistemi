package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.LibroDTO;
import com.vo.LibroVO;


public interface LibroDAO {
	
	public void addLibro(String sql, Connection con, LibroDTO libroDTO) throws ClassNotFoundException, SQLException;
	
	public ArrayList<LibroVO> findAllLibro(String sql,Connection con) throws SQLException;
	
	public LibroVO findLibroById(String sql,Connection con, int id) throws ClassNotFoundException, SQLException;

	


}

