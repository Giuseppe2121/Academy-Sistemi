package com.sistemi.service;

import java.util.List;

import com.sistemi.entity.Student;

public interface StudentService {
	
	public void addStudent(Student student);      //questo add controlla l'addStudent del repository
	
	public void updateStudent(Student student);
	
	public void removeStudent(int id);
	
	public void findAllStudents();
	
	public void findAllStudentsByLastName(String lastName);

	


}
