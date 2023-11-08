package com.facade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.LibroDAO;
import com.dao.LibroDAOImpl;

import com.dto.LibroDTO;
import com.sql.SqlScript;
import com.vo.LibroVO;

public class LibroFacadeDAOImpl {
	
	private LibroDAO libroDAO = null;
	
	public void addLibro(String sql, Connection con, LibroDTO libroDTO) throws ClassNotFoundException, SQLException {
		
		if (libroDAO == null) {

			libroDAO = new LibroDAOImpl();

		}

		libroDAO.addLibro(SqlScript.sqlLibroInsert, con, libroDTO);

	}
	
	public ArrayList<LibroVO> findAllLibro(String sql, Connection con) throws SQLException{
		
		if (libroDAO == null) {

			libroDAO = new LibroDAOImpl();

		}

		return libroDAO.findAllLibro(SqlScript.sqlLibroList, con);

	}
	
	public LibroVO findLibroById(String sql,Connection con, int id) throws ClassNotFoundException, SQLException {
		
		if (libroDAO == null) {

			libroDAO = new LibroDAOImpl();

		}

		return libroDAO.findLibroById(SqlScript.sqlLibroById, con, id);

		
		
	}
	
	
	

}
