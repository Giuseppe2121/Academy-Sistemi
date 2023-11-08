package com.main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainApplication {

	// step dichiarazione driver,url,username,password
	private static final String dbDriver = "com.mysql.cj.jdbc.Driver";
	private static final String dbUrl = "jdbc:mysql://localhost:3306/corso";
	private static final String dbUser = "root";
	private static final String dbPassword = "";

	// eccezioni (un metodo nella firma può accettare anche piu eccezioni)
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// script sql anonimo di insert
		String sqlInsert = "insert into student(first_name, last_name, age)values (?,?,?)";
		// script sql anonimo di update
		String sqlUpdate = "update student set age = ? where id = ? ";
		//script sql anonimo di delete
		String sqlDelete = "delete from student where id = ?";
		//script sql anonimo di read
		String sqlRead = "select * from student";

		// Step 1 = apertura della connessione

		// 1.1 (indicazione del driver di connesione)
		Class.forName(dbDriver);

		// 1.2(indicazione di url,username e password)
		Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

		// Step 2 = CRUD

		// 2.1-----> INSERT
		PreparedStatement psInsert = con.prepareStatement(sqlInsert);   //la classe (PreparedStatement
		//insert into student(fist_name, last_name, age)values (?,?,?)
		//CONCRETIZZAZIONE DEI PACEHOLDER(?,?,?)
		psInsert.setString(1,"Giuliano");
		psInsert.setString(2,"Verdini");
		psInsert.setInt(3, 19);
		
		//insert into student(fist_name, last_name, age)values (Giuliano,Verdini,19)
		
		//metodo execeute update (va invocato dopo un'operazione di insert,update delete)
		//rappresenta una sincronizzazione dell' operazione implementata precedentemente(insert)
		//il metodo executeUpdate va SEMPRE invocato dopo operazioni di inserimento/aggiornamento e cancellazione
		psInsert.executeUpdate();
		
		//2.2----> UPDATE 
		PreparedStatement psUpdate = con.prepareStatement(sqlUpdate);  //la classe (PreparedStatement)
		//update student set age = ? where id = ?
		//concretizzazione dei paceholder (?,?)
		psUpdate.setInt(1, 31);  // 1 è il primo (?) e il secondo si riferisce a 31 che è l'età cambiata
		psUpdate.setInt(2, 2);   //il primo 2 si riferisce al secondo (?) e l'altro 2 è l'id di teresa
		
		psUpdate.executeUpdate();
		
		//2.3 DELETE
		PreparedStatement psDelete = con.prepareStatement(sqlDelete);
		//delete from student where id = ?
		//concretizzazione del paceholder (?)
		psDelete.setInt(1, 5);   //1 è il ?, 5 è l'id che vogliamo eliminare
		//delete from student where id = 5
		
		psDelete.executeUpdate();
		
		//2.4 READ
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(sqlRead);
		
		while(rs.next()) {
			System.out.println(rs.getInt("id") + " " + rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getInt("age"));
			
			
		}
	
	}

}
