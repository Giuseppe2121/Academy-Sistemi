package com.sistemi.repository;

import java.util.List;

import com.sistemi.entity.Course;
import com.sistemi.entity.Student;

public interface CourseStudentRepository {
	
	public void addCourse(Course course);
	
	public void addStudent (Student student);
	
	public List<Student> findAllStudentByCourse(int courseId);
	
	public List<Course> findAllCoursesByStudent(int studentId);
	
	

}
