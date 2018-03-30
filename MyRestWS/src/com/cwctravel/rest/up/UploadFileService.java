package com.cwctravel.rest.up;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/files")
public class UploadFileService {
	private static final String FILE_PATH = "c:\\file.log.xml";

	@POST
	@Path("/uploadImage")
	@Consumes(MediaType.APPLICATION_OCTET_STREAM)
	public Response uploadImage(InputStream uploadedInputStream) {
		System.out.println("hit --> !");
		String uploadedFileLocation = "d://uploaded/" + (int) (Math.random() * 1000) + ".png";
		writeToFile(uploadedInputStream, uploadedFileLocation);
		String output = "File uploaded to : " + uploadedFileLocation;

		return Response.status(200).entity(output).build();
	}

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {
		System.out.println("hit --> !");
		String uploadedFileLocation = "d://uploaded/" + fileDetail.getFileName();
		writeToFile(uploadedInputStream, uploadedFileLocation);
		String output = "File uploaded to : " + uploadedFileLocation;

		return Response.status(200).entity(output).build();
	}

	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) {
		try {
			OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];
			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("/get")
	@Produces("text/plain")
	public Response getFile() {
		File file = new File(FILE_PATH);
		ResponseBuilder response = Response.ok(file);
		response.header("Content-Disposition", "attachment; filename=\"file_from_server.log\"");
		return response.build();
	}
}