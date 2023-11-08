package com.dao;

import java.sql.SQLException;

import com.dto.AcademyDTO;

public interface AcademyDAO {
	
	public void addAcademy(AcademyDTO academyDTO) throws ClassNotFoundException, SQLException;

}
