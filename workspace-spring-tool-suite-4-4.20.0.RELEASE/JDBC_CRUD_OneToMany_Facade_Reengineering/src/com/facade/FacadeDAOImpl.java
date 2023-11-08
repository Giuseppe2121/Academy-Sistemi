package com.facade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManagerI;
import com.dao.CourseDAO;
import com.dao.CourseDAOImpl;
import com.dao.ReviewDAO;
import com.dao.ReviewDAOImpl;
import com.dto.CourseDTO;
import com.dto.ReviewDTO;
import com.sql.SqlScript;
import com.vo.ReviewVO;

public class FacadeDAOImpl {

	private CourseDAO courseDAO = null;

	private ReviewDAO reviewDAO = null;

	public void addCourse(ConnectionManagerI conI, Connection con, CourseDTO courseDTO)
			throws ClassNotFoundException, SQLException {

		if (courseDAO == null) {

			courseDAO = new CourseDAOImpl();

		}

		courseDAO.addCourse(SqlScript.sqlCourseInsert, conI, con, courseDTO);

	}

	public int findCourseMaxId(ConnectionManagerI conI, Connection con) throws SQLException {

		if (courseDAO == null) {

			courseDAO = new CourseDAOImpl();

		}

		return courseDAO.findCourseMaxId(SqlScript.sqlCourseMaxId, conI, con);

	}

	public void addReview(ConnectionManagerI conI, Connection con, ReviewDTO reviewDTO)
			throws ClassNotFoundException, SQLException {

		if (reviewDAO == null) {

			reviewDAO = new ReviewDAOImpl();

		}

		reviewDAO.addReview(SqlScript.sqlReviewInsert, conI, con, reviewDTO);

	}

	public ArrayList<ReviewVO> findReviewLocationByCourse(ConnectionManagerI conI, Connection con, int courseId)
			throws ClassNotFoundException, SQLException {

		if (reviewDAO == null) {

			reviewDAO = new ReviewDAOImpl();

		}

		return reviewDAO.findReviewLocationByCourse(SqlScript.sqlReviewLocationsByCourse, conI, con, courseId);

	}

}
