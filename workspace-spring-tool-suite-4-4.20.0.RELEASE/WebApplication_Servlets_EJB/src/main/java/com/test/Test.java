package com.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.StudentDAO;
import com.dto.StudentDTO;
import com.singleton.DAOSingleton;
import com.sql.SqlScript;
import com.vo.StudentVO;

class Test {

	@org.junit.jupiter.api.Test
	void addStudent() throws ClassNotFoundException, SQLException {

		int nRowsInserted = 0;

		Connection con = DAOSingleton.getSingletonConnection();

		StudentDTO studentDTO = new StudentDTO("francesca", "totta", 45);

		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstance();
		nRowsInserted = studentDAO.addStudent(SqlScript.sqlInsert, con, studentDTO);

		assertEquals(nRowsInserted,1);

	}
	
	@org.junit.jupiter.api.Test
	void findAllStudent() throws ClassNotFoundException, SQLException {

		ArrayList<StudentVO> students = new ArrayList<>();

		Connection con = DAOSingleton.getSingletonConnection();


		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstance();
		students = studentDAO.findAllStudent(SqlScript.sqlRead, con);
		

		assertEquals(students.size(),19);

	}
	
	

}
