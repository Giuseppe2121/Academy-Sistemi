package com.sistemi.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sistemi.entity.Student;
import com.sistemi.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	@Value("${message.insert.success}")
	private String insertSuccess;
	@Value("${message.insert.fail}")
	private String insertFail;
	@Value("${message.update.success}")
	private String updateSuccess;
	@Value("${message.update.fail}")
	private String updateFail;
	@Value("${message.delete.success}")
	private String deleteSuccess;
	@Value("${message.delete.fail}")
	private String deleteFail;
	@Value("${message.read.fail}")
	private String readFail;
	
	
//	API che sostituisce il system.out con il log.info
	Logger log = LoggerFactory.getLogger(this.getClass());  //avremmo potuto scrivere anche StudentServiceImpl.getClass al posto del this
	
	
	/*
	 * Spring Dependency Injection
	 * chiediamo all IoC Container di istanziare
	 * la clase StudentRepositoryImpl
	 * che implementa l'interfaccia StudentRepository
	 * 
	 * l'IoC container istanzierà correttamente la classe StudentRepositoryImpl 
	 * in quanto tale classe verà riconosciuta come uno Spring bean in quanto
	 * annotata con @Repository che è un annotation di Stereorype
	 * 
	 * dietro le quinte l'IoC Container eseguirà la seguente azione
	 * 
	 * private StudentRepository studentRepositry  = new StudentRepositoryImpl();
	 */
	
	@Autowired  
	private StudentRepository studentRepository;    //mettiamo nome interfaccia della Repository

	@Override
	public void addStudent(Student student) {
		/*
		 * invocazione del metodo addStudent della repository
		 * controllo se l'operazione è andata bene o male
		 */
		
		try {
		
		//NEW (ogetto Entity istanziato per la prim volta)
		 studentRepository.addStudent(student);
		 log.info(insertSuccess);

	}
		
		catch (IllegalArgumentException ex) {
			
			log.info(insertFail);
			
			
		}
			
	}

	@Override
	public void updateStudent(Student student) {
		
		
		try {
			
			 studentRepository.updateStudent(student);
			 log.info(updateSuccess);

		}
			
			catch (IllegalArgumentException ex) {
				
				log.info(updateFail);
				
				
			}
	

	}

	@Override
	public void removeStudent(int id) {
		

		try {
			
			 studentRepository.removeStudent(id);
			 log.info(deleteSuccess);

		}
			
			catch (IllegalArgumentException ex) {
				
				log.info(deleteFail);
				
				
			}
		

	}

	@Override
	public void findAllStudents() {
		
		List<Student> students = new ArrayList<>();
		
		students = studentRepository.findAllStudents();    //il metodo getResultList restituisce una list, eccon perche usiamo List<>
		
		if (!students.isEmpty()) {
			
		students.forEach(student->log.info(student.toString()));
		
		}
		
		else {
			log.info(readFail);
		}
		
		
	}

	@Override
	public void findAllStudentsByLastName(String lastName) {
		
		List<Student> students = new ArrayList<>();
		
		students = studentRepository.findAllStudentsByLastName(lastName);   
		
		if (!students.isEmpty()) {
			
		students.forEach(student->log.info(student.toString()));
		
		}
		
		else {
			log.info(readFail);
		}
		

	}

}
