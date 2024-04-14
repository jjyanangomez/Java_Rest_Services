package com.krakedev.evaluacion.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.persistencia.TestConexionBDD;

@Path("bases")
public class ServiciosConexion {
	@Path("probarConexion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void probarCon() {
		TestConexionBDD tcb = new TestConexionBDD();
		try {
			tcb.probarConexion();
		} catch (KrakeException e) {
			e.printStackTrace();
		}
	}
}
