package com.ejb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.key.SessionKey;
import com.page.Page;
import com.singleton.DAOSingleton;
import com.sql.SqlScript;
import com.vo.StudentVO;

@Stateless
public class StudentDeleteEJB implements StudentDeleteEJBLocal {

	@Override
	public String removeStudent(String id, HttpServletRequest request) throws ClassNotFoundException, SQLException {

		String page = Page.error;

		ArrayList<StudentVO> students = new ArrayList<>();

		int nRowsDeleted = 0;

		Connection con = DAOSingleton.getSingletonConnection();

		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstance();
		nRowsDeleted = studentDAO.removeStudent(SqlScript.sqlDelete, con, Integer.parseInt(id));

		if (nRowsDeleted > 0) {

			students = studentDAO.findAllStudent(SqlScript.sqlRead, con);

		}

		if (!(request.getRequestedSessionId() == null) && !request.isRequestedSessionIdValid()) {

			ConnectionManager.closeConnection(con);
		}

		if (!students.isEmpty()) {

			HttpSession session = request.getSession();
			session.setAttribute(SessionKey.studentsListKey, students);
			page = Page.students;
		}

		return page;
	}

}
