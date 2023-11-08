package com.ejb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.dto.StudentDTO;
import com.key.SessionKey;
import com.page.Page;
import com.singleton.DAOSingleton;
import com.sql.SqlScript;
import com.vo.StudentVO;

@Stateless

public class StudentUpdateEJB implements StudentUpdateEJBLocal {

	@Override
	public String updateStudent(HttpServletRequest request, StudentDTO studentDTO, String id) throws ClassNotFoundException, SQLException {
		
		ArrayList<StudentVO> students = new ArrayList<>();
		
		int nRowsUpdate = 0;
		
		String page = Page.error;
		
		Connection con = DAOSingleton.getSingletonConnection();
		
		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstance();
		nRowsUpdate = studentDAO.updateStudent(SqlScript.sqlUpdate, con, studentDTO, Integer.parseInt(id));
		
		if(nRowsUpdate>0) {
			
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
