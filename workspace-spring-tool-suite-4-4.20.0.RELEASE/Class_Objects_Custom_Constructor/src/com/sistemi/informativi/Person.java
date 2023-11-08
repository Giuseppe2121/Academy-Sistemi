package com.sistemi.informativi;

public class Person {

	/*
	 * una metodologiua alternativa ai metodi di set e get per l'implenetazione del
	 * principio di Information Hiding in Java è quella di dichiarare le variabili
	 * di istanza e private e consentirne la manipolazione diretta al costruttore
	 * custom anzichè consentirlo ai metodi set
	 * 
	 */

	private String firstName;
	private String lastName;
	private int age;

	/*
	 * Se all'interno di una classe java vengono inseriti uno o piu costruttori il
	 * costruttore di default non esisterà più
	 */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Person() {
		
	}

	public Person(String firstName, String lastName, int age) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
	

}
