package com.sistemi.informativi;

public class MainApplication {

	public static void main(String[] args) {
		
		
		
		/*
		 * generazione di un Oggetto
		 * a partire dalla classe 
		 * Person
		 * 
		 * p1= variabile locale(perchè dichirata dentro il corpo di un metodo
		 */
		Person p1 = new Person (); 
		
		
		p1.firstName="mario";
		p1.lastName="rossi";
		p1.age=23;
		
		p1=null;
		
	
		
		System.out.println(p1.firstName + " " + p1.lastName + " " + p1.age);
		
		 
	}
	
	
	
}
