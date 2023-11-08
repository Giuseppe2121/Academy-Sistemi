package com.sistemi.informativi;

public class MainApplication {

	public static void main(String[] args) {
		
		Person p1 = new Person();
		
		
		p1.setFirstName("Giulio");
		
		p1.setLastName("Bianchi");
		
		p1.setAge(29);
		
		System.out.println(p1.getFirstName() + " " + p1.getLastName() + " " + p1.getAge());
		
		
		

	}

}
