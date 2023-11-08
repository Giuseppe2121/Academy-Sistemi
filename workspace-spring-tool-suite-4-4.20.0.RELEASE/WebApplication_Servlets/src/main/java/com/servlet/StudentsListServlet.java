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

@WebServlet("/students")
public class StudentsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentsListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recuperare dal DAO le info
		Connection con = null;

		ArrayList<StudentVO> students = new ArrayList<>();

		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstance();

		HttpSession session = null;

		try {
			con = DAOSingleton.getSingletonConnection();
			// restituzione di una ArrayList con gli students recuperati dal db
			students = studentDAO.findAllStudent(SqlScript.sqlRead, con);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {

			try {
				ConnectionManager.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// END FLUSSO DI RICHIESTA

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
