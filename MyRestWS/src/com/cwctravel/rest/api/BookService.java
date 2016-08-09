package com.cwctravel.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/books")
public class BookService {
	// Test Git
	// the matrix parameter is "author=umashankar", separate by a semi colon ";"
	// http://localhost:8080/MyRestWS/books/2011;author=umashankar;country=malaysia
	@GET
	@Path("{year}")
	public Response getBooks(@PathParam("year") String year, @MatrixParam("author") String author, @MatrixParam("country") String country) {

		return Response.status(200).entity("getBooks is called, year : " + year + ", author : " + author + ", country : " + country).build();

	}

}
