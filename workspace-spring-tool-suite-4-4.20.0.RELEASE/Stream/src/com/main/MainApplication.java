package com.main;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainApplication {

	public static void main(String[] args) {

		/*
		 * inizializzazione di uno Stream da scratch
		 */
		Stream<String> colori = Stream.of("giallo", "blu", "rosso", "verde", "rosso");
//		colori.forEach(colore->System.out.println("stream colori" + " " + colore));

		/*
		 * distinct è una funzione che può ritornare uno stream che rappresenta uno
		 * stream coincidente a quello di partenza o un sottoinsieme di quell di
		 * partenza
		 */
		Stream<String> coloriUnivoci = colori.distinct().sorted();
//		coloriUnivoci.forEach(coloreUnivoco -> System.out.println("stream colori" + " " + coloreUnivoco));
		
		Stream<String> coloreGiallo = coloriUnivoci.filter(colore->colore.equals("giallo"));
//		coloreGiallo.forEach(colore->System.out.println("stream coloreGiallo" + " " + colore));
		
		/*
		 * inizializzazione di uno stream di integer da scratch
		 */
		
		Stream<Integer> numeri = Stream.of(9,8,5,4);
//		numeri.forEach(numeri->System.out.println("stream numeri" + " " + numeri));
		
		Stream<Integer> numeriDoppi = numeri.map(numero->(numero*2));
		numeriDoppi.forEach(numero->System.out.println("stream numeri" + " " + numero));
		
		ArrayList<String> corsi = new ArrayList<>();
		corsi.add("java");
		corsi.add("Spring");
		Stream<String> corsiStream = corsi.stream();
		corsiStream.forEach(corso->System.out.println("corsi Stream" + " " + corso));
		
		Integer arrayInteger [] = new Integer [2];
		arrayInteger[0] = 23;
		arrayInteger[1] = 67;
		Stream<Integer> streamInteger = Stream.of(arrayInteger);
		streamInteger.forEach(numero->System.out.println("stream Integer" + " " + numero));
		
		IntStream rangeStream = IntStream.range(1, 11);
		rangeStream.forEach(range->System.out.println("range stream" + " " + range));
		
				

	}

}
