package com.main;

import java.sql.SQLException;

import com.dao.AcademyDAO;
import com.dao.AcademyDAOImpl;
import com.dto.AcademyDTO;

public class MainApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		/*
		 * Oggetto con la sua
		 * iniziale rappresentazione
		 */
		AcademyDTO academyDTO = new AcademyDTO.AcademyDTOBuilder("1028x", "Rome").build();
		
		AcademyDAO academyDAO = new AcademyDAOImpl();
		academyDAO.addAcademy(academyDTO);
		
		

	}

}
