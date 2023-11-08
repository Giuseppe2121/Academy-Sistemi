package com.sql;

public interface SqlScript {

	// script sql anonimo di insert
	public String sqlInsert = "insert into student(first_name, last_name, age)values (?,?,?)";
	// script sql anonimo di update
	public String sqlUpdate = "update student set first_name = ?, last_name = ?, age = ? where id = ? ";
	// script sql anonimo di delete
	public String sqlDelete = "delete from student where id = ?";
	// script sql anonimo di read
	public String sqlRead = "select * from student";
	
	public String sqlById =  "select * from student where id = ?";

}



