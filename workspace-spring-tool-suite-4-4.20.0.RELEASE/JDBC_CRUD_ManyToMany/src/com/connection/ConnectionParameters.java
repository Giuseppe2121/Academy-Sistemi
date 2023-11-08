package com.connection;

public interface ConnectionParameters {

	static final String dbDriver = "com.mysql.cj.jdbc.Driver";
	static final String dbUrl = "jdbc:mysql://localhost:3306/corso";  //cambiare "corso" e "3306"(se cambia anche la porta) con nome di eventuale nuovo database se serve (in caso di nuovo progetto)
	static final String dbUser = "root";
	static final String dbPassword = "";

}
