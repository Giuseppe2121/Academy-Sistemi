package com.sistemi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sistemi.entity.Course;
import com.sistemi.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseStudentRepositoryImpl implements CourseStudentRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void addCourse(Course course) {

		em.persist(course);

	}

	@Override
	public void addStudent(Student student) {

		em.persist(student);

	}

	@Override
	public List<Student> findAllStudentByCourse(int courseId) {

		return em.find(Course.class, courseId).getStudents();

	}

	@Override
	public List<Course> findAllCoursesByStudent(int studentId) {

		return em.find(Student.class, studentId).getCourses();

	}

}
