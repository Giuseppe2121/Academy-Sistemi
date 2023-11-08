package com.business;

import java.sql.SQLException;
import java.util.ArrayList;

import com.enumeration.Choice;

public interface ChoiceResponseI {
	
	public ArrayList<Object> choiceRepsonse(Choice choice) throws ClassNotFoundException, SQLException;

}
