package com.krakedev.evaluacion.persistencia;

import java.sql.Connection;
import java.sql.SQLException;

import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.utils.ConexionBDD;

public class TestConexionBDD {
	public void probarConexion() throws KrakeException {
		Connection con = null;
		try {
			con = ConexionBDD.obtenerConexion();
			if (con!=null) {
				System.out.println("Conexión Exitosa");
			}else {
				System.out.println("Error al obtener Conexión");
			}
		} catch (KrakeException e) {
			e.printStackTrace();
			throw new KrakeException("Error al obtener Conexión");
		}finally {
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
