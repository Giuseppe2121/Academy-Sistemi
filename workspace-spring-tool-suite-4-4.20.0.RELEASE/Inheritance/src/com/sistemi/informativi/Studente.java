package com.sistemi.informativi;

public class Studente extends Persona {
	
	public void studia() {
		System.out.println("studia");
	}
	
	@Override
	public void dorme() {
		
		System.out.println("dorme poco quando è sotto esame");
	}
	
	

}
