package com.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.business.CrudCheck;
import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;
import com.dto.StudentDTO;
import com.sql.SqlScript;
import com.vo.StudentVO;

public class MainApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = ConnectionManager.getConnection();
		
		// 1.RICHIESTA DI DUE INSERT SULLA TABELLA STUDENT
		
		//loos coupling
		
		//VERIFICA INSERT TABELLA STUDENT
	    StudentDTO studentDTO1 = new StudentDTO("Giovanni","Piccoli",36);
		StudentDTO studentDTO2 = new StudentDTO("Giada","miretti",31);
		CrudCheck.checkOperation(SqlScript.sqlInsert, con, studentDTO1, 0);
		CrudCheck.checkOperation(SqlScript.sqlInsert, con, studentDTO2, 0);
		//END VERIFICA INSERT TABELLA STUDENT
		
		//VERIFICA UPDATE TABELLA STUDENT
		StudentDTO studentDTO3 = new StudentDTO("Sara","levato",33);
		CrudCheck.checkOperation(SqlScript.sqlUpdate, con, studentDTO3, 8);
		//VERIFICA END UPDATE TABELLA STUDENT
		
		//VERIFICA REMOVE
		CrudCheck.checkOperation(SqlScript.sqlDelete, con, null, 7);
		//END VERIFICA REMOVE
		
		//VERIFICA READ
		CrudCheck.checkRead(SqlScript.sqlRead, con);
		//END VERIFICA READ


////	StudentDAO studentDAO = new StudentDAOImpl (); questo va via quando facciamo il CrudCheck
//		studentDAO.addStudent(SqlScript.sqlInsert, con, studentDTO1 );
//		studentDAO.addStudent(SqlScript.sqlInsert, con, studentDTO2);
//		//-----FINE INSERT
		
		//2 RICHIESTA DI UPDATE SULLA TABELLA STUDENT
//		StudentDTO studentDTO3 = new StudentDTO("Maria", "Gelsi", 33);
//		studentDAO.updateStudent(SqlScript.sqlUpdate,con, studentDTO3, 3);
		//fine update
		
		//richiesta cancellazione di uno studente
//		studentDAO.removeStudent(SqlScript.sqlDelete, con, 6);
		//fine cancellazione
		
		//richiesta lettura
//		ArrayList<StudentVO> students = studentDAO.findAllStudent(SqlScript.sqlRead,con);
//		students.forEach(student-> System.out.println(student.toString()));
		
		//ConnectionManager.closeConnection(con);
		
		
		
		
		

	}

}
