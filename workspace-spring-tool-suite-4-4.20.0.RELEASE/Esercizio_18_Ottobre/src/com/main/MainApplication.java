package com.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManager;
import com.dto.LibroDTO;
import com.facade.LibroFacadeDAOImpl;
import com.sql.SqlScript;
import com.vo.LibroVO;

public class MainApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = ConnectionManager.getConnection();
		
		LibroFacadeDAOImpl facadeDAO = new LibroFacadeDAOImpl();
		
		LibroDTO libroDTO = new LibroDTO("harry potter","Rowling",300);
		LibroDTO libroDTO01 = new LibroDTO("1984","Orwell",200);
		LibroDTO libroDTO02 = new LibroDTO("Divina Commedia","Dante Alighieri",400);
		facadeDAO.addLibro(SqlScript.sqlLibroInsert, con, libroDTO);
		facadeDAO.addLibro(SqlScript.sqlLibroInsert, con, libroDTO01);
		facadeDAO.addLibro(SqlScript.sqlLibroInsert, con, libroDTO02);
		
		
		ArrayList<LibroVO>libri = facadeDAO.findAllLibro(SqlScript.sqlLibroList, con);
		libri.forEach(libro->System.out.println(libro));
		
		LibroVO libro = facadeDAO.findLibroById(SqlScript.sqlLibroById, con, 2);
		System.out.println(libro);

		


		
		

	}

}
