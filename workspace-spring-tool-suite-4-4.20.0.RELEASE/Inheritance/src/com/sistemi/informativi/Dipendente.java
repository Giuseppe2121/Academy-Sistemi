package com.sistemi.informativi;

public class Dipendente extends Persona {
	
	public void lavora() {
		
		System.out.println("lavora");
	}
	
	@Override
	public void dorme() {
		System.out.println("dorme compatibilmente agli orari lavorativi");
	}

}
