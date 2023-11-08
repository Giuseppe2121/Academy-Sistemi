package com.dto;

import java.io.Serializable;

public class ReviewDTO implements Serializable {

	private static final long serialVersionUID = -8001919657909503919L;

	private String location;
	private int courseId;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCourse_id() {
		return courseId;
	}

	public void setCourse_id(int courseId) {
		this.courseId = courseId;
	}

	public ReviewDTO(String location, int courseId) {
		super();
		this.location = location;
		this.courseId = courseId;
	}

	protected ReviewDTO() {

	}

}
