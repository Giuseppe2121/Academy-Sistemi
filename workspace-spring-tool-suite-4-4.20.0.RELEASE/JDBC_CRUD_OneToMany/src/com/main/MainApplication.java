package com.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManager;
import com.dao.CourseDAO;
import com.dao.CourseDAOImpl;
import com.dao.ReviewDAO;
import com.dao.ReviewDAOImpl;
import com.dto.CourseDTO;
import com.dto.ReviewDTO;
import com.sql.SqlScript;
import com.vo.ReviewVO;

public class MainApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = ConnectionManager.getConnection();
		
	 // inserire un corso e in successione due review collegate al corso appena inserito
		CourseDAO courseDAO = new CourseDAOImpl();
		CourseDTO courseDTO = new CourseDTO("React", "FrontEnd Framework");
		courseDAO.addCourse(SqlScript.sqlCourseInsert, con, courseDTO);
		
		/*
		 * Recupero dell'id del corso appena inserito in maniera tale che tale id
		 * possa essee utilizato come FK per le review da inserire succesivamente
		 */
		int maxCourseId = courseDAO.findCourseMaxId(SqlScript.sqlCourseMaxId, con);
	
		ReviewDAO reviewDAO = new ReviewDAOImpl();
		ReviewDTO reviewDTO1 = new ReviewDTO("Paris", maxCourseId);
		ReviewDTO reviewDTO2 = new ReviewDTO("Toronto", maxCourseId);
		
		//inserimento di de review associate al corso inserito
		reviewDAO.addReview(SqlScript.sqlReviewInsert, con, reviewDTO1);
		reviewDAO.addReview(SqlScript.sqlReviewInsert, con, reviewDTO2);
		
		//Ricerca delle location di tutte le review relative al corso con id = 5
		
		ArrayList<ReviewVO> reviews = reviewDAO.findReviewLocationByCourse(SqlScript.sqlReviewLocationsByCourse, con, 5);
		reviews.forEach(location->System.out.println(location));

		
		
		
		
		
		
	}

}
