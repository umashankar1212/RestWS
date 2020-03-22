package com.cwctravel.rest.client;

import java.io.File;

import com.sun.jersey.api.client.Client;

public class RESTClient {

	public static void main(String args[]) throws Exception {
		File f = new File("/home/jboss/myfile.txt");
		sendFile(f);
	}

	public static void sendFile(File file) throws Exception {
		String BASE_URL = "http://localhost:8080/MyRestWS/rest/upload";
		Client client = Client.create();
	}

}