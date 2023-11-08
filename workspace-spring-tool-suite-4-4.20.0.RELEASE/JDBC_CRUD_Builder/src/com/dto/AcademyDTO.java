package com.dto;

import java.io.Serializable;
import java.sql.Date;

public class AcademyDTO implements Serializable {

	private static final long serialVersionUID = -8284834069073919458L;

	private String code;
	private String location;
	private Date date;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public AcademyDTO(AcademyDTOBuilder builder) {
		
		this.code=builder.code;
		this.location=builder.location;
		this.date=builder.date;
		
	}

	// BUILDER CLASS //inner class
	public static class AcademyDTOBuilder {

		private String code;
		private String location;
		private Date date;

		public AcademyDTOBuilder(String code, String location) {

			this.code = code;
			this.location = location;
		}

		public AcademyDTOBuilder setDate(Date date) {
			this.date = date;
			return this;

		}

		public AcademyDTO build() {
			return new AcademyDTO(this);

		}

	}

}