package com.krakedev.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.entidades.Cliente;
import com.krakedev.excepciones.KrakeDevException;
import com.krakedev.persistencia.ClienteBdd;

@Path("apiRest")
public class ServiciosCliente {
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Cliente c) {
		System.out.println("-----"+c);
		ClienteBdd cli = new ClienteBdd();
		try {
			cli.insertar(c);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response presentar() {
		ClienteBdd cli = new ClienteBdd();
		ArrayList<Cliente> listClientes = null;
		try {
			listClientes = cli.obtener();
			return Response.ok(listClientes).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
