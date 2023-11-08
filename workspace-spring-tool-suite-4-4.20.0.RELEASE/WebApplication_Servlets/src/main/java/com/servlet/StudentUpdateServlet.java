package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.dto.StudentDTO;
import com.singleton.DAOSingleton;
import com.sql.SqlScript;
import com.vo.StudentVO;


@WebServlet("/update")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Connection con = null;
		
		HttpSession session = null;
		
		int nRowsUpdate = 0;
		
		ArrayList<StudentVO> students = new ArrayList<>();
		
		
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		
		
		StudentDTO studentDTO = new StudentDTO(firstName,lastName,Integer.parseInt(age));
		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstance();
		
		try {
			con = DAOSingleton.getSingletonConnection();
			nRowsUpdate = studentDAO.updateStudent(SqlScript.sqlUpdate, con, studentDTO, Integer.parseInt(id));
			
			if(nRowsUpdate>0) {
				students = studentDAO.findAllStudent(SqlScript.sqlRead, con);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

		finally {

			try {
				ConnectionManager.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		if (!students.isEmpty()) {
			
			session = request.getSession();
			session.setAttribute("students", students);
			response.sendRedirect("students.jsp");
		}
		
		else {
			
			response.sendRedirect("error.html");
		}
		
		
		
		
		
	}

}
