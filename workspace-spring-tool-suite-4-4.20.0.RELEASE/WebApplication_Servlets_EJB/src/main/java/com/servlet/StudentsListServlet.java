package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejb.StudentListEJBLocal;


@WebServlet("/students")
public class StudentsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
	@EJB
	private StudentListEJBLocal students;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			response.sendRedirect(students.findAllStudents(request));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}