package com.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connection.ConnectionManager;
import com.dto.AcademyDTO;
import com.singleton.ConnectionSingleton;
import com.sql.SqlScript;

public class AcademyDAOImpl implements AcademyDAO {

	@Override
	public void addAcademy(AcademyDTO academyDTO) throws ClassNotFoundException, SQLException {
		
		PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlAcademyInsert, 
				ConnectionSingleton.getSingletonConnection());
		
		long today = System.currentTimeMillis();
		Date date = new Date(today);
		
		/*
		 * aggiungiamo all'oggetto AcademyDTO in input 
		 * tramite pattern Builder una date (quella attuale)
		 */
		
		AcademyDTO academyDTONew = new AcademyDTO.AcademyDTOBuilder(academyDTO.getCode(), academyDTO.getLocation()).setDate(date).build();
		
		ps.setString(1,academyDTONew.getCode());
		ps.setString(2,academyDTONew.getLocation());
		ps.setDate(3,academyDTONew.getDate());
		
		ps.executeUpdate();


		
		
	}
	

}
