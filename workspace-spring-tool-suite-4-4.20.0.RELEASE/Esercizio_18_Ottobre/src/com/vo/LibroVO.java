package com.vo;

import java.io.Serializable;

public class LibroVO implements Serializable{
	
	
	private static final long serialVersionUID = -6195543055409281103L;
	
	private int id;
	
	private String nome_libro;
	
	private String autore;
	
	private int pagine;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	
	protected LibroVO(){
		
	}
	
	

	public LibroVO(int id, String nome_libro, String autore, int pagine) {
		super();
		this.id = id;
		this.nome_libro = nome_libro;
		this.autore = autore;
		this.pagine = pagine;
	}

	@Override
	public String toString() {
		return "LibroVO [id=" + id + ", nome_libro=" + nome_libro + ", autore=" + autore + ", pagine=" + pagine + "]";
	}
	
	

}
