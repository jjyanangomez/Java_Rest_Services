package com.krakedev.evaluacion.entidades;

import java.util.Date;

public class HistorialMovimiento {
	private int id;
	private String id_producto;
	private int cantidad;
	private Date fecha_movimiento;
	
	public HistorialMovimiento() {
	}
	public HistorialMovimiento(int id, String id_producto, int cantidad, Date fecha_movimiento) {
		super();
		this.id = id;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
		this.fecha_movimiento = fecha_movimiento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getId_producto() {
		return id_producto;
	}
	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFecha_movimiento() {
		return fecha_movimiento;
	}
	public void setFecha_movimiento(Date fecha_movimiento) {
		this.fecha_movimiento = fecha_movimiento;
	}
	
	@Override
	public String toString() {
		return "HistorialMovimiento [id=" + id + ", id_producto=" + id_producto + ", cantidad=" + cantidad
				+ ", fecha_movimiento=" + fecha_movimiento + "]";
	}
}
