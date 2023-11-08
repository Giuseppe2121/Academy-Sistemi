package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManagerI;
import com.dto.ReviewDTO;
import com.vo.ReviewVO;

public interface ReviewDAO {
	
	public void addReview(String sql, ConnectionManagerI conI, Connection con, ReviewDTO reviewDTO) throws ClassNotFoundException,SQLException;

	
	public ArrayList<ReviewVO> findReviewLocationByCourse(String sql, ConnectionManagerI conI, Connection con, int courseId) throws ClassNotFoundException, SQLException;
	
}