package com.krakedev.servicios;


import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.entidades.Cliente;
import com.krakedev.excepciones.KrakeDevException;
import com.krakedev.persistencia.ClientesBDD;

//El uso del path permite redireccionar cunado se navegue en la URL

@Path("customers")
public class ServiciosClientes {
	
	//Normalmente en el path se coloca el nombre del metodo 
	@Path("m1")
	@GET
	public String saludar() {
		return "HOla mundo Rest Web Services";
	}
	
	@Path("mbuscar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente buscar() {
		Cliente objCliente = new Cliente("1105834079","Juan José",1);
		return objCliente;
	}
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Cliente c) {
		System.out.println("-----"+c);
		ClientesBDD cli = new ClientesBDD();
		try {
			cli.insertar(c);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Cliente c) {
		System.out.println("Actualizando Cliente-----"+c);
		ClientesBDD cli = new ClientesBDD();
		try {
			cli.actualizar(c);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	
	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerClientes(){
		ClientesBDD cli = new ClientesBDD();
		ArrayList<Cliente> listClientes = null;
		try {
			listClientes = cli.recuperarTodo();
			return Response.ok(listClientes).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("buscarPorCedula/{cedulaParam}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorCedula(@PathParam("cedulaParam") String cedula){
		ClientesBDD cli = new ClientesBDD();
		Cliente c = null;
		try {
			c = cli.buscarPorPK(cedula);
			return Response.ok(c).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	
	@Path("buscarPorHijos/{HijosParam}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorCedula(@PathParam("HijosParam") int hijos){
		ClientesBDD cli = new ClientesBDD();
		ArrayList<Cliente> listClientes = null;
		try {
			listClientes = cli.recuperarPorHijos(hijos);
			return Response.ok(listClientes).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}






