package com.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;
import com.dto.StudentDTO;
import com.vo.StudentVO;

import come.message.Message;

public class CrudCheck {
	
	public  static void checkOperation(String sql, Connection con, StudentDTO studentDTO, int id) throws ClassNotFoundException, SQLException {
		
		 StudentDAO studentDAO = new StudentDAOImpl ();  //istanzia il DAO
		
		
		 switch ( sql.charAt(0)) {
		 case 'i' : case  'I' : 
			 if (studentDAO.addStudent(sql, con, studentDTO)>0) {
				 System.out.println(Message.opInsert);
				 
			 }
		 
			 else {
				 
				 System.out.println(Message.opInsertErr);
			 }
		 
		 break;
		 
		 case 'u' : case 'U' :
			 if(studentDAO.updateStudent(sql,con,studentDTO,id)>0) {
				 
				 System.out.println(Message.opUpdate);
			 }
			 
			 else {
				 
				 System.out.println(Message.opUpdateErr);
			 }
			 
			 break;
			 
		 case 'd' : case 'D' : 
			 if (studentDAO.removeStudent(sql, con, id)>0) {
				 
				 System.out.println(Message.opDelete);
			 }
			 
			 else {
				 
				 System.out.println(Message.opDeleteErr);
			 }
			 
			 break;

		 }
	
		
	}
	
	public static void checkRead (String sql, Connection con) throws SQLException {
		
		StudentDAO studentDAO = new StudentDAOImpl ();
		ArrayList<StudentVO> students = studentDAO.findAllStudent(sql, con);
		
		if(students!= null && !students.isEmpty()) {
			
			System.out.println(Message.opRead);
			
			students.forEach(student->System.out.println(students.toString()));
		}
		
		else{
			
			System.out.println(Message.opReadErr);
			
		}
		
		
		
		
	}
	
	

}
