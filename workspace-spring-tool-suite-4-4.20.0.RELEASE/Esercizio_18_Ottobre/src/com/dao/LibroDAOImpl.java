package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManager;
import com.dto.LibroDTO;
import com.vo.LibroVO;

public class LibroDAOImpl implements LibroDAO {

	@Override
	public void addLibro(String sql, Connection con, LibroDTO libroDTO) throws ClassNotFoundException, SQLException {
		
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql,con);
		ps.setString(1, libroDTO.getNome_libro());
		ps.setString(2, libroDTO.getAutore());
		ps.setInt(3, libroDTO.getPagine());
		
		ps.executeUpdate();

		
	}

	@Override
	public ArrayList<LibroVO> findAllLibro(String sql, Connection con) throws SQLException {
		
		ArrayList <LibroVO> libro = new ArrayList<>();
		
		LibroVO libroVO = null;
		
		ResultSet rs = ConnectionManager.getResultSet(sql, con);
		
		while (rs.next()) {
			
			libroVO = new LibroVO (rs.getInt("id"),rs.getString("nome_libro"), rs.getString("autore"), rs.getInt("pagine"));
			
			libro.add(libroVO);
		
		}
		return libro;
	}

	@Override
	public LibroVO findLibroById(String sql, Connection con, int id) throws ClassNotFoundException, SQLException {
		
		
		
		LibroVO libroVO = null;
		
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
			libroVO = new LibroVO(rs.getInt("id"),null,null,0);
		
		
		return libroVO;
	
	}

}
