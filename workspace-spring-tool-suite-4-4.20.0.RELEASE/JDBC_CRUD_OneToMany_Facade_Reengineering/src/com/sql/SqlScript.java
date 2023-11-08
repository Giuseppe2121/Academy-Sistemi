package com.sql;

public interface SqlScript {
	
	public String sqlCourseInsert = "insert into course(title,description) values(?,?)";
	
	public String sqlReviewInsert = "insert into review (location,course_id) values (?,?)";
	
	public String sqlCourseMaxId = "select max(id) from course";
	
	public String sqlReviewLocationsByCourse = "select review.location from review,course where review.course_id=course.id and course.id=?";

}
