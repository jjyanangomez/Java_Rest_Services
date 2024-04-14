package com.krakedev.evaluacion.entidades;

import java.math.BigDecimal;

public class Producto {
	private String id;
	private String nombre;
	private BigDecimal precio_venta;
	private BigDecimal precio_compra;
	private String id_categoria;
	
	public Producto() {

	}
	public Producto(String id, String nombre, BigDecimal precio_venta, BigDecimal precio_compra, String id_categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio_venta = precio_venta;
		this.precio_compra = precio_compra;
		this.id_categoria = id_categoria;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(BigDecimal precio_venta) {
		this.precio_venta = precio_venta;
	}
	public BigDecimal getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(BigDecimal precio_compra) {
		this.precio_compra = precio_compra;
	}
	public String getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(String id_categoria) {
		this.id_categoria = id_categoria;
	}
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio_venta=" + precio_venta + ", precio_compra="
				+ precio_compra + ", id_categoria=" + id_categoria + "]";
	}
}
