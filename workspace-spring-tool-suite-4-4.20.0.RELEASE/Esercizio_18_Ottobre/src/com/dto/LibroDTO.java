package com.dto;

import java.io.Serializable;

public class LibroDTO implements Serializable {

	private static final long serialVersionUID = 7359801186400567502L;

	private String nome_libro;

	private String autore;

	private int pagine;

	public String getNome_libro() {
		return nome_libro;
	}

	public void setNome_libro(String nome_libro) {
		this.nome_libro = nome_libro;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public int getPagine() {
		return pagine;
	}

	public void setPagine(int pagine) {
		this.pagine = pagine;
	}
	
	protected LibroDTO () {
		
	}
	
	

	public LibroDTO(String nome_libro, String autore, int pagine) {
		super();
		this.nome_libro = nome_libro;
		this.autore = autore;
		this.pagine = pagine;
	}

	@Override
	public String toString() {
		return "LibroDTO [nome_libro=" + nome_libro + ", autore=" + autore + ", pagine=" + pagine + "]";
	}
	
	

}
