package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.StudentDTO;
import com.ejb.StudentRegistrationEJBLocal;

@WebServlet("/registration")
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	 * Dependency injection fornita da JAVA EE
	 * per implementare il pattern IoC
	 * 
	 * Dietro le quinte l'EHB Container eseguirà
	 * il seguente codice : 
	 * private StudentRegistrationEJBLocal studentRegistration = new StudentRegistrationEJB();
	 * 
	 * La Dependency Injection JAVA EE va applicata nel seguente modo:
	 * dichiarare una variabile di istanza del tipo Interfaccia EJB 
	 * rispetto alla classe EJB che si vuole chiedere di istanziare 
	 * e tale variabile di istanza deve essere preceduta dall'Annotaion @EJB
	 */
	
	@EJB        //questa è la dependency injection
	private StudentRegistrationEJBLocal studentRegistration;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//richiesta
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		
		StudentDTO studentDTO = new StudentDTO(firstName, lastName, Integer.parseInt(age));
		
		/*
		 * Invocazione di un metodo dell'EJB StudentRegistrationEJB
		 */
		
		//risposta
		try {
			response.sendRedirect(studentRegistration.addStudent(studentDTO, request));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		

	}

}
