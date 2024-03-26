package com.krakedev.inventario.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.krakedev.inventario.entidades.Categoria;
import com.krakedev.inventario.entidades.Producto;

@Path("productos")
public class ServiciosProducto {
	
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertar(Producto p) {
		System.out.println("Resultado-----"+p);
	}	
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizar(Producto p) {
		System.out.println("Actualizando Cliente-----"+p);
	}
	
	@Path("recuperarTodos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Producto> recuperarTodos() {
		ArrayList<Producto> ListProductos = new ArrayList<Producto>();
		ListProductos.add(new Producto("C-137","Galletas",new Categoria(1,"Granos"),2.3,60));
		ListProductos.add(new Producto("C-138","Granola",new Categoria(1,"Granos"),0.5,60));
		ListProductos.add(new Producto("C-139","Jamos de pavo",new Categoria(3,"Embutidos"),4.6,60));
		return ListProductos;
	}
}
