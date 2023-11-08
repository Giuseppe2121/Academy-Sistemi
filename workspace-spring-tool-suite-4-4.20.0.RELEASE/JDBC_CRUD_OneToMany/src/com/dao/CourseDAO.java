package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.dto.CourseDTO;

public interface CourseDAO {
	
	public void addCourse(String sql, Connection con, CourseDTO courseDTO) throws ClassNotFoundException,SQLException;
	
	public int findCourseMaxId(String sql, Connection con) throws SQLException;

}
