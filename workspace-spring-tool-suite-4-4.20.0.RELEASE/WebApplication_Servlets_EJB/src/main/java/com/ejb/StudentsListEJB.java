package com.ejb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.LocalBean;
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
@LocalBean
public class StudentsListEJB implements StudentListEJBLocal {

	@Override
	public String findAllStudents(HttpServletRequest request) throws ClassNotFoundException, SQLException {

		String page = Page.error;

		ArrayList<StudentVO> students = new ArrayList<>();

		Connection con = DAOSingleton.getSingletonConnection();

		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstance();
		students = studentDAO.findAllStudent(SqlScript.sqlRead, con); // "students" è dell'arraylist

		if (!(request.getRequestedSessionId() == null) && !request.isRequestedSessionIdValid()) {

			ConnectionManager.closeConnection(con);
		}
		
		if(!students.isEmpty()) {
			
			HttpSession session = request.getSession();
			session.setAttribute(SessionKey.studentsListKey, students);
			page = Page.students;
		}

		return page;
	}

}
