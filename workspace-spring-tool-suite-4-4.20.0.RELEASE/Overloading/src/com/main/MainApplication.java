package com.main;

import com.operazioni.Operazione;

public class MainApplication {

	public static void main(String[] args) {

		Operazione operazione = new Operazione();
		double somma1 = operazione.somma(54.87, 23.98);
		System.out.println("somma 1");
		int somma2 = operazione.somma(21, 340, 56);
		System.out.println("somma2");
		int somma3= operazione.somma(9, 12);
		System.out.println("somma3");
		

	}

}
