package com.krakedev.entidades;

public class Libro {
	private String isbn;
	private String nombre;
	private int  numeroPaginas;
	
	public Libro() {

	}
	public Libro(String isbn, String nombre, int numeroPaginas) {
		super();
		this.isbn = isbn;
		this.nombre = nombre;
		this.numeroPaginas = numeroPaginas;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	@Override
	public String toString() {
		return "libro [isbn=" + isbn + ", nombre=" + nombre + ", numeroPaginas=" + numeroPaginas + "]";
	}
	
	
}
