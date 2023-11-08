package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.connection.ConnectionManagerI;
import com.dto.CourseDTO;

public interface CourseDAO {
	
	public void addCourse(String sql, ConnectionManagerI conI, Connection con, CourseDTO courseDTO) throws ClassNotFoundException, SQLException;

	public int findCourseMaxId(String sql, ConnectionManagerI conI, Connection con) throws SQLException;

	
}
