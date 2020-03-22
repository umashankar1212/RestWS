package com.cwctravel.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.jersey.spi.resource.Singleton;

@Path("/user")
@Singleton
public class Hello {
	@Autowired
	public String abc;

	@GET
	@Path("/hey")
	@Produces(MediaType.TEXT_HTML)
	public Response topQueriesXml() {
		return Response.status(Status.ACCEPTED).entity("Div says hello to you !!").build();
	}
}
