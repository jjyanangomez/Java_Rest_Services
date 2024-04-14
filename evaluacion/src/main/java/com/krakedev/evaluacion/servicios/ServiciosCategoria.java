package com.krakedev.evaluacion.servicios;

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

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.persistencia.HistorialBDD;

@Path("funciones")
public class ServiciosCategoria {
	@Path("probarInsertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Categoria c) {
		HistorialBDD his = new HistorialBDD();
		try {
			his.insertar(c);
			return Response.ok().build();
		} catch (KrakeException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("probarActualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Categoria c) {
		HistorialBDD his = new HistorialBDD();
		try {
			his.actualizar(c);
			return Response.ok().build();
		} catch (KrakeException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("probarBuscar/{paramId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorCedula(@PathParam("paramId") String id){
		HistorialBDD his = new HistorialBDD();
		Categoria c = null;
		try {
			c = his.buscarPorId(id);
			return Response.ok(c).build();
		} catch (KrakeException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("probarRecuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response probarRecuperar() {
		ArrayList<Categoria> listCategorias = new ArrayList<>();
		HistorialBDD his = new HistorialBDD();
		try {
			listCategorias =his.recuperarTodo();
			return Response.ok(listCategorias).build();
		} catch (KrakeException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
