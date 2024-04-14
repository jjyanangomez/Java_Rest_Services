package com.krakedev.evaluacion.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.utils.ConexionBDD;

public class HistorialBDD {
	public void insertar(Categoria c) throws KrakeException{
		Connection con = null;
		try {
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = con.prepareStatement("INSERT INTO categorias(id,nombre) "
					+ "VALUES (?, ?);");
			ps.setString(1, c.getId());
			ps.setString(2, c.getNombre());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeException("Error al insertar la categoria: "+e.getMessage());
		} catch (KrakeException e) {
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
	
	public void actualizar(Categoria c) throws KrakeException{
		Connection con = null;
		try {
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = con.prepareStatement("UPDATE categorias Set nombre = ? WHERE id = ?;");
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeException("Error al actualizar la categoria: "+e.getMessage());
		} catch (KrakeException e) {
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
	public Categoria buscarPorId(String id) throws KrakeException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		Categoria c = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select * from categorias WHERE id = ?;");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				String idParam = rs.getString("id");
				String nombre = rs.getString("nombre");
				c = new Categoria(idParam,nombre);
			}else {
				c = new Categoria();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeException("Error al consultar por ID "+e.getMessage());
		} catch (KrakeException e) {
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
		return c;
	}
	
	public ArrayList<Categoria> recuperarTodo() throws KrakeException{
		ArrayList<Categoria> listCategorias = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		Categoria c = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("Select * from categorias");
			rs = ps.executeQuery();
			while (rs.next()) {
				String idparm = rs.getString("id");
				String nombre = rs.getString("nombre");
				c = new Categoria(idparm,nombre);
				listCategorias.add(c);
			}
			
		} catch (KrakeException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeException("Error al consultar: "+e.getMessage());
		}finally {
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		return listCategorias;
	}
}
