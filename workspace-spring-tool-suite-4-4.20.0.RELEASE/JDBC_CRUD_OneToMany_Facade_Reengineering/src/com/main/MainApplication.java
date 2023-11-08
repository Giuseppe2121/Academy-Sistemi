package com.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManager;
import com.connection.ConnectionManagerI;
import com.dto.CourseDTO;
import com.dto.ReviewDTO;
import com.facade.FacadeDAOImpl;
import com.sql.SqlScript;
import com.vo.ReviewVO;

public class MainApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ConnectionManagerI conI = new ConnectionManager();
		
		Connection con = conI.getConnection();
		
		FacadeDAOImpl facadeDAO = new FacadeDAOImpl();
		
	
	 // inserire un corso e in successione due review collegate al corso appena inserito
//		CourseDAO courseDAO = new CourseDAOImpl();
		CourseDTO courseDTO = new CourseDTO("Javascript", "FrontEnd Framework");
//		courseDAO.addCourse(SqlScript.sqlCourseInsert, con, courseDTO);
		facadeDAO.addCourse(conI, con, courseDTO);
		
		
		
		/*
		 * Recupero dell'id del corso appena inserito in maniera tale che tale id
		 * possa essee utilizato come FK per le review da inserire succesivamente
		 */
		int maxCourseId = facadeDAO.findCourseMaxId(conI, con);
	
//		ReviewDAO reviewDAO = new ReviewDAOImpl();
		ReviewDTO reviewDTO1 = new ReviewDTO("Genova", maxCourseId);
		ReviewDTO reviewDTO2 = new ReviewDTO("Milano", maxCourseId);
		
		facadeDAO.addReview(conI, con, reviewDTO1);
		facadeDAO.addReview(conI, con, reviewDTO2);
		
		//inserimento di de review associate al corso inserito
//		reviewDAO.addReview(SqlScript.sqlReviewInsert, con, reviewDTO1);
//		reviewDAO.addReview(SqlScript.sqlReviewInsert, con, reviewDTO2);
		
		//Ricerca delle location di tutte le review relative al corso con id = 5
		
		ArrayList<ReviewVO> reviews = facadeDAO.findReviewLocationByCourse(conI, con, maxCourseId);
		reviews.forEach(location->System.out.println(location));
		

		
	}

}
