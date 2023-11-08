package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.ReviewDTO;
import com.vo.ReviewVO;

public interface ReviewDAO {
	
	public void addReview(String sql,Connection con,ReviewDTO reviewDTO) throws ClassNotFoundException,SQLException;
	
	public ArrayList<ReviewVO> findReviewLocationByCourse(String sql, Connection con, int courseId) throws ClassNotFoundException, SQLException;

}
