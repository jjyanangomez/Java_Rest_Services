package com.krakedev.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.entidades.Cliente;
import com.krakedev.excepciones.KrakeDevException;
import com.krakedev.util.ConexionBdd;

public class ClienteBdd {
	public void insertar(Cliente c) throws KrakeDevException {
		Connection con = null;
		try {
			con = ConexionBdd.obtenerConexion();
			PreparedStatement ps = con.prepareStatement("INSERT INTO cliente (cedula, nombre) "
					+ "VALUES (?, ?);");
			ps.setString(1, c.getCedula());
			ps.setString(2, c.getNombre());
			
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
	
	public ArrayList<Cliente> obtener() throws KrakeDevException{
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		Cliente c = null;
		try {
			con = ConexionBdd.obtenerConexion();
			ps = con.prepareStatement("Select * from cliente");
			rs = ps.executeQuery();
			while (rs.next()) {
				String cedula = rs.getString("cedula");
				String nombre = rs.getString("nombre");;
				c = new Cliente(cedula,nombre);
				clientes.add(c);
			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar: "+e.getMessage());
		}finally {
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return clientes;
	}
}
