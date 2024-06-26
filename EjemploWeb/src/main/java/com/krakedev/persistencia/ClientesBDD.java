package com.krakedev.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.entidades.Cliente;
import com.krakedev.excepciones.KrakeDevException;
import com.krakedev.utils.ConexionBdd;

public class ClientesBDD {
	public void insertar(Cliente c) throws KrakeDevException {
		Connection con = null;
		try {
			con = ConexionBdd.obtenerConexion();
			PreparedStatement ps = con.prepareStatement("INSERT INTO clientes (cedula, nombre, numeroHijos) "
					+ "VALUES (?, ?, ?);");
			ps.setString(1, c.getCedula());
			ps.setString(2, c.getNombre());
			ps.setInt(3, c.getNumeroHijos());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al insertar al cliente: "+e.getMessage());
		} catch (KrakeDevException e) {
			throw e;
		}finally {
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public void actualizar(Cliente c) throws KrakeDevException {
		Connection con = null;
		try {
			con = ConexionBdd.obtenerConexion();
			PreparedStatement ps = con.prepareStatement("UPDATE clientes SET nombre = ?, "
					+ " numeroHijos = ? "
					+ " WHERE cedula = ?;");
			ps.setString(1, c.getNombre());
			ps.setInt(2, c.getNumeroHijos());
			ps.setString(3, c.getCedula());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al actualizar al cliente: "+e.getMessage());
		} catch (KrakeDevException e) {
			throw e;
		}finally {
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	public ArrayList<Cliente> recuperarTodo() throws KrakeDevException{
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		Cliente c = null;
		try {
			con = ConexionBdd.obtenerConexion();
			ps = con.prepareStatement("Select * from clientes");
			rs = ps.executeQuery();
			while (rs.next()) {
				String cedula = rs.getString("cedula");
				String nombre = rs.getString("nombre");
				int hijos = rs.getInt("numeroHijos");
				c = new Cliente(cedula,nombre,hijos);
				clientes.add(c);
			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar: "+e.getMessage());
		}
		return clientes;
	}
	
	
	
	public Cliente buscarPorPK(String cedula) throws KrakeDevException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		Cliente c = null;
		try {
			con = ConexionBdd.obtenerConexion();
			ps = con.prepareStatement("Select * from clientes Where cedula = ?");
			ps.setString(1, cedula);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String cedulaParametro = rs.getString("cedula");
				String nombre = rs.getString("nombre");
				int hijos = rs.getInt("numeroHijos");
				c = new Cliente(cedulaParametro,nombre,hijos);
			}else {
				c = new Cliente();
			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar: "+e.getMessage());
		}
		return c;
	}
	
	
	
	public ArrayList<Cliente> recuperarPorHijos(int hijos) throws KrakeDevException{
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		Cliente c = null;
		try {
			con = ConexionBdd.obtenerConexion();
			ps = con.prepareStatement("Select * from clientes where numeroHijos = ?;");
			ps.setInt(1, hijos);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String cedula = rs.getString("cedula");
				String nombre = rs.getString("nombre");
				int hijosParam = rs.getInt("numeroHijos");
				c = new Cliente(cedula,nombre,hijosParam);
				clientes.add(c);
			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar los clientes según los numeros de hijos: "+e.getMessage());
		}
		return clientes;
	}
}
