package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManager;
import com.dto.ReviewDTO;
import com.vo.ReviewVO;

public class ReviewDAOImpl implements ReviewDAO {

	@Override
	public void addReview(String sql, Connection con, ReviewDTO reviewDTO) throws ClassNotFoundException,SQLException {
		
		
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		ps.setString(1, reviewDTO.getLocation());
		ps.setInt(2, reviewDTO.getCourse_id());
		
		ps.executeUpdate();
		
		
	} 
	@Override
	public ArrayList<ReviewVO> findReviewLocationByCourse(String sql, Connection con, int courseId) throws ClassNotFoundException, SQLException {
		
		ArrayList<ReviewVO> reviews = new ArrayList<>();
		
		ReviewVO reviewVO = null;
		
		
        //select review.location from,course where review.course_id=course.id and course.id=?
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		ps.setInt(1, courseId );
		//SQL----> CONCRETIZZATO
		//ResultSet sempre con la lettura
		
		/*
		 * E' possibile ricavare un resultset anche a partire da un oggetto preparedSstatement 
		 * invocando il metodo executeQuery() su preparedStatement.
		 * 
		 * è possibile anche ricavare un ResulSet a partire da uno Statement invocando il metodo 
		 * createStatement su Statement 
		 */
		ResultSet rs = ps.executeQuery();	
		
		while (rs.next()) {
			
			reviewVO = new ReviewVO(0,rs.getString("location"), 0);
			
			reviews.add(reviewVO);
		
		}
		
		return reviews;
			
			
		
		
	}
		
	}


