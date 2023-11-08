package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManager;
import com.dto.StudentDTO;
import com.mysql.cj.protocol.Resultset;
import com.vo.StudentVO;

public class StudentDAOImpl implements StudentDAO {
	@Override
	public int addStudent(String sql, Connection con, StudentDTO studentDTO) throws ClassNotFoundException, SQLException {  //sql,con,studentDTo sono le variabili
		
		/*
		 * sql = "insert into student (first_name,last_name,age) values (?,?,?)
		 */
		
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		//recuperare dal DTO le informaizoni che servono per concretizzare i paceholder(?,?,?)
		ps.setString(1, studentDTO.getFirstName());
		ps.setString(2, studentDTO.getLastName());
		ps.setInt(3, studentDTO.getAge());
		
		return ps.executeUpdate();
		
	}
	@Override
	public int updateStudent (String sql, Connection con, StudentDTO studentDTO, int id) throws ClassNotFoundException, SQLException {
		
	    //sql = "updateStudent firstName = ?, lastName = ?, age = ? where id = ?" 
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		ps.setString(1, studentDTO.getFirstName());
		ps.setString(2, studentDTO.getLastName());
		ps.setInt(3, studentDTO.getAge());
		ps.setInt(4, id);
		
		 return ps.executeUpdate();
			 
	}
	
    @Override
	public int removeStudent (String sql, Connection con, int id) throws ClassNotFoundException, SQLException {
		
		//sql = "delete from student where id = ?"
		
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		ps.setInt(1, id);
		
		return ps.executeUpdate();   //public int poichè executeUpdate viene restituito come intero
		
	}
	
    @Override
	public ArrayList<StudentVO>findAllStudent (String sql, Connection con) throws SQLException {
		
		ArrayList <StudentVO> students = new ArrayList<>();
		
		
		//sql = select * from student
		
		ResultSet rs = ConnectionManager.getResultSet(sql,con);
		
		while (rs.next()) {
			
			/*
			 * Per ogni Oggetto del ResultSet
			 * effettuiamo una copia del suo contenuto all'interno
			 * di un oggetto StudentVO che, a differenza 
			 * dell'Oggetto del ResultSet. è Serializable
			 * in quanto la classe StudentVO implements Serializable
			 * (AZIONE FATTA DA NOI)
			 */
			
			StudentVO studentVO = new StudentVO (rs.getInt("id"),rs.getString("first_name"), rs.getString("last_name"), rs.getInt("age"));
			
			students.add(studentVO);
		}
		
		return students;
	
	}
	@Override
	public StudentVO findStudentById(String sql, Connection con, int id) throws ClassNotFoundException, SQLException {
		
		StudentVO studentVO = null;
		
		//sql = select * from student where id=?
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		ps.setInt(1, id);
		//sql = select * from student where id=id (in input al metodo)
		
		ResultSet rs =  ps.executeQuery();
		
		if(rs.next()) {
			
			studentVO = new StudentVO (rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getInt("age"));
		}
		
		
		return studentVO;
	}
	

}
