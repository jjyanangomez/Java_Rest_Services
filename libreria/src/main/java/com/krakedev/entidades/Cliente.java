package com.krakedev.entidades;

public class Cliente {
	private String Cedula;
	private String nombre;
	public Cliente() {

	}
	public Cliente(String cedula, String nombre) {
		super();
		Cedula = cedula;
		this.nombre = nombre;
	}
	public String getCedula() {
		return Cedula;
	}
	public void setCedula(String cedula) {
		Cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Cliente [Cedula=" + Cedula + ", nombre=" + nombre + "]";
	}
	
	
}
