package com.vo;

import java.io.Serializable;

public class ReviewVO implements Serializable {

	private static final long serialVersionUID = 3688220441024622344L;

	private int id;
	private String location;
	private int courseId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	protected ReviewVO() {
		
		
	}

	public ReviewVO(int id, String location, int courseId) {
		super();
		this.id = id;
		this.location = location;
		this.courseId = courseId;
	}
	
	

	@Override
	public String toString() {
		return "ReviewVO [id=" + id + ", location=" + location + ", courseId=" + courseId + "]";
	}
	
	

}
