package com.sistemi.informativi;

public class MainApplication {

	public static void main(String[] args) {

		/*
		 * in questo caso la JVM alloca l'oggetto all'interno dell'heap e
		 * contestualmente popola l'oggetto con i valori passati in input (IN UNUNICA
		 * OPERAZIONE COMPUTAZIONALE)
		 */
		Person p1 = new Person("Giacomo", "Pucci", 27);

		Person p2 = new Person("Giacomo", "Pucci", 27);

		if (p1 == p2) {

			System.out.println("p1 e p2 sono ugauli fra loro");

		}

		else {

			System.out.println("p1 e p2 sono diverse fra loro");
		}

		p1 = p2;

		if (p1 == p2) {

			System.out.println("p1 e p2 sono ugauli fra loro");

		}

		else {

			System.out.println("p1 e p2 sono diverse fra loro");
		}

		// fare if-else
		/*
		 * assegniazione di Reference stiamo assegnando la reference p1 alla reference
		 * p2
		 * 
		 * quello che succede nella JVM è che la refrence p1 referenza lo stesso
		 * oggetto(SPAZIO DI MEMORIA) che ref
		 */

		// override
		// 2 operazioni computazionali
		System.out.println(p1.toString());

	}

}
