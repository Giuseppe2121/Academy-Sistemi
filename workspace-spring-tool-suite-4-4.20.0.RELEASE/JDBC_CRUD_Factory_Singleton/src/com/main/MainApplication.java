package com.main;

import java.sql.SQLException;
import java.util.ArrayList;

import com.business.ChoiceResponse;
import com.business.ChoiceResponseI;
import com.enumeration.Choice;

public class MainApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ChoiceResponseI response = new ChoiceResponse();
		
		ArrayList<Object> objects = response.choiceRepsonse(Choice.CUSTOMER);
		
		objects.forEach(object->System.out.println(objects.toString()));   //(object->) è una variabile

	}

}
