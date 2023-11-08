package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.bean.Azienda;

public class MainApplication {

	public static void main(String[] args) {

		/*
		 * inizializzazione di un ArrayList le cui locazioni di memoria contengono
		 * reference di tipo Azienda
		 */

		// <> consente di tipizzare, a sinistra specifichiamo il tipo, a destra possiamo
		// metterle anche vuote
		ArrayList<Azienda> aziende = new ArrayList<>();

		Azienda azienda1 = new Azienda("1028G", "company1", "Roma", 34);
		Azienda azienda2 = new Azienda("1028H", "company2", "Milano", 67);

		// la JVM crea una locazione di memoria con indice 0
		aziende.add(azienda1);
		// la JVM crea una locazione di memoria con indice 1
		aziende.add(azienda2);

		// for each
		for (Azienda azienda : aziende) {
			System.out.println("Contenuto ArrayList aziende" + " " + azienda.toString());

		}

		ArrayList<Integer> numeri = new ArrayList<>();

		/*
		 * la JVM consapevole del fatto che non possono essere inseriti dei tipi
		 * primitivi in un ArreyList effettua l'AUTOBOXING, ovvero la conversione
		 * implicita ad un oggetto wrapper dei tipi primitivi
		 */
		numeri.add(8);
		numeri.add(7);
		numeri.add(9);

		// "numero" reference, nome cursore
		for (Integer numero : numeri) {

			System.out.println("contenuto Arrayist numeri" + " " + numero.toString());
		}

		ArrayList<String> giorni = new ArrayList<>();
		giorni.add("lunedi");
		giorni.add("martedi");
		giorni.add("mercledi");
		giorni.add("giovedi");
		giorni.add("venerdi");
		giorni.add("sabato");
		giorni.add("domenica");
		giorni.add("lunedi");

		/*
		 * Tutte le strutture dati dinamiche (collections) consentono di utilizzare un
		 * metodo predefinito di API di nome forEach
		 */

		giorni.forEach(giorno -> System.out.println("contenuto ArrayList giorni" + " " + giorno));

		HashSet<String> giorniset = new HashSet<>();
		giorniset.add("lunedi");
		giorniset.add("martedi");
		giorniset.add("mercoledi");
		giorniset.add("giovedi");
		giorniset.add("venerdi");
		giorniset.add("sabato");
		giorniset.add("domenica");
		giorniset.add("lunedi");

		giorniset.forEach(giorno -> System.out.println("contenuto HashSet giochiset" + " " + giorno));

		/*
		 * quando si usa Generics per l'HashMap occore indicare due tipi: il primo
		 * rappresenta il tipo della chiave che si intende usare per assegnare l'indice
		 * alle varie locazini di memoria; il secondo rappresenta il tipo della
		 * reference cioè il vero e proprio valore inserito all'interno delle locaziondi
		 * di memoria
		 */
		HashMap<String, Azienda> aziendeMap = new HashMap<>();
		Azienda aziendemap1 = new Azienda("1034H", "company10", "Torino", 78);
		Azienda aziendemap2 = new Azienda("1042J", "company11", "Palermo", 12);

		// prima locazione di memoria mette key1, seconda locazione aziendemap1
		// (nell'heamp)
		aziendeMap.put("key1", aziendemap1);
		aziendeMap.put("key2", aziendemap2);

		
		aziendeMap.forEach((key, value) -> System.out.println("contenuto HashMap aziendeMap" + " " + key + " " + value));
		
		/*
		 * ESEMPIO DI CONVERSIONE DA STRUTTURA DATI STATICA ARRAY 
		 * A STRUTTURA DATI DINAMICA ArrayList
		 */
		
		Integer arrInteger [] = new Integer[2];
		arrInteger[0] = 9;
		arrInteger[1] = 45;
		
		List<Integer> integerList = Arrays.asList(arrInteger);
		
		integerList.forEach(numero->System.out.println("contenuto List integerList" + " " + numero));
		
				

	}

}
