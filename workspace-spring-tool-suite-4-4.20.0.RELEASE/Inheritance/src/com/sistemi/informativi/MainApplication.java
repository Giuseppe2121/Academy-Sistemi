package com.sistemi.informativi;

public class MainApplication {

	public static void main(String[] args) {

		Persona persona = new Persona();

		persona.mangia();
		persona.dorme();
		persona.cammina();

		Studente studente = new Studente();
		// invocazione metodi ereditati dal padre

		// override
		studente.dorme();
		studente.cammina();
		studente.mangia();
		// metodo solo del figlio
		studente.studia();

		Dipendente dipendente = new Dipendente();

		dipendente.cammina();
		// metodo solo del dipendente
		dipendente.lavora();
		dipendente.mangia();
		// override
		dipendente.dorme();
		
		Studente_lavoratore studente_lavoratore = new Studente_lavoratore();
		 studente_lavoratore.cammina();
		 studente_lavoratore.dorme();
		 studente_lavoratore.mangia();
		 //metodo solo dello studente lavoratore
		 studente_lavoratore.studiaElavora();
		 studente_lavoratore.studia();
		
	}

}
