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
import com.singleton.DAOSingleton;
import com.sql.SqlScript;
import com.vo.StudentVO;

@WebServlet("/delete")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = null;

		ArrayList<StudentVO> students = new ArrayList<>();

		int nRowsDeleted = 0;

		Connection con = null;

		/*
		 * Dobbiamo recuperare l'id dello student selezionato all'interno della pagina
		 * students.jsp
		 */
		String id = request.getParameter("id");

		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstance();

		try {
			con = DAOSingleton.getSingletonConnection();
			nRowsDeleted = studentDAO.removeStudent(SqlScript.sqlDelete, con, Integer.parseInt(id));
			if (nRowsDeleted > 0) {

				students = studentDAO.findAllStudent(SqlScript.sqlRead, con);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

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
