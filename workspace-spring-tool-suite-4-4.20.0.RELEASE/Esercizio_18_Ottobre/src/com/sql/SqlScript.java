package com.sql;

public interface SqlScript {
	
	public String sqlLibroInsert = "insert into libreria (nome_libro,autore,pagine) values(?,?,?)";
	
	public String sqlLibroList = "select * from libreria";
	
	public String sqlLibroById = "select * from libreria where id=?";
	
	

}
