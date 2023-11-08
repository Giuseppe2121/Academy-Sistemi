package com.sistemi.repository;

import java.util.List;

import com.sistemi.entity.Course;
import com.sistemi.entity.Review;

public interface CourseReviewRepository {
	
	public void addCourse(Course course);
	
	public void addReview(Review review);
	
	public List<Review> findAllReviewsByCourse(int courseId);

}
