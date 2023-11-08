package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.ConnectionManager;
import com.dto.CourseDTO;

public class CourseDAOImpl implements CourseDAO {

	@Override
	public void addCourse(String sql, Connection con, CourseDTO courseDTO) throws ClassNotFoundException, SQLException {
		
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		ps.setString(1, courseDTO.getTitle());
		ps.setString(2, courseDTO.getDescription());
		
		ps.executeUpdate();
	
	}
	@Override
	public int findCourseMaxId(String sql, Connection con) throws SQLException{
		
		//sql = select max(id) from course
		
		ResultSet rs = ConnectionManager.getResultSet(sql, con);
		
		int maxId = 0;
		
		if (rs.next()) { //next è un metodo predefinito 
		   //resultset unica struttura dati in cui l'indice parte da 1 e non da 0 (quind diverso da arraylist ecc)
		
		maxId =rs.getInt(1);
		}
		
		return maxId;
		
		
	}
	
	
	

}
