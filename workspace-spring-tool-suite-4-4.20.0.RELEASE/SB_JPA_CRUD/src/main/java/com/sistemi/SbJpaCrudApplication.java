package com.sistemi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistemi.entity.Student;
import com.sistemi.service.StudentService;

@SpringBootApplication
public class SbJpaCrudApplication implements CommandLineRunner{
	
	@Autowired
	private StudentService studentService;
	
	//CommandLineRunner run 

	public static void main(String[] args) {
		SpringApplication.run(SbJpaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//INSERIMENTO
		Student studentOne = new Student("Gainluca", "Gerace",29);
		Student studentTwo = new Student("Teresa", "Proto",32);
		Student studentThree = new Student("Sara", "Melchiorri",22);
		
		studentService.addStudent(studentOne);
		studentService.addStudent(studentTwo);
		studentService.addStudent(studentThree);
		
		//FINE INSERIMENTO
		
		
		//AGGIORNAMENTO
		Student studentToUpdate = new Student(3,"Sara", "Melchiorri",24);
		
		studentService.updateStudent(studentToUpdate);
		
		//FINE AGGIORNAMENTO
		
		
		
		//CANCELLAZIONE
		studentService.removeStudent(2);
		
		//FINE CANCELLAZIONE
		
		
		//LETTURA TUTTI STUDENTI
		studentService.findAllStudents();
		//FINE LETTURA
		
		
		//LETTURA PER COGNOME
		studentService.findAllStudentsByLastName("Gerace");
		//FINE LETTURA
		
	}

}
