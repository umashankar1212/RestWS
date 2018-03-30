package com.cwctravel.rest.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.cwctravel.rest.api.info.AirportInfo;

/*
 * XML
 * http://localhost:8080/MyRestWS/api/webservice/airports
 * http://localhost:8080/MyRestWS/api/webservice/airports/SFO
 * 
 * JSON
 * http://localhost:8080/MyRestWS/api/webservice/json/airports/
 * http://localhost:8080/MyRestWS/api/webservice/json/airports/SFO
 * 
 * Add airport
 * http://localhost:8080/MyRestWS/api/webservice/airports/add/BLR/Bangalore Int airport
 * 
 * Delete airport
 * http://localhost:8080/MyRestWS/api/webservice/airports/delete/BLR
 * 
 * 
 */
@Path("/webservice")
public class RSServiceApi {
	private static Map<String, AirportInfo> airportsByCodeMap = new HashMap<String, AirportInfo>();

	/*
	 * Get All AirportInfos as XML
	 */
	@GET
	@Path("/airports")
	@Produces("application/xml")
	public List<AirportInfo> getAirportInfos() {
		return new ArrayList<AirportInfo>(airportsByCodeMap.values());
	}

	/*
	 * Get AirportInfo by airport code as XML
	 */
	@GET
	@Path("/airports/{airportCode}")
	@Produces("application/xml")
	public AirportInfo getAirportInfo(@PathParam("airportCode") String airportCode) {
		return airportsByCodeMap.get(airportCode);
	}

	/*
	 * Add AirportInfo, parameters as airportCode and airportName 
	 * return Airports as XML
	 */

	@POST
	@Path("/airports/add/{airportCode}/{airportName}")
	@Consumes("text/plain")
	@Produces("application/xml")
	public List<AirportInfo> createAirportInfo(@PathParam("airportCode") String airportCode, @PathParam("airportName") String airportName) {
		AirportInfo airportInfo = new AirportInfo();
		airportInfo.setAirportCode(airportCode);
		airportInfo.setAirportName(airportName);
		airportsByCodeMap.put(airportCode, airportInfo);
		return new ArrayList<AirportInfo>(airportsByCodeMap.values());
	}

	/* 
	 * Delete airport info by airport code 
	 * return Airports as XML
	 */
	@DELETE
	@Path("/airports/delete/{airportCode}")
	@Consumes("text/plain")
	@Produces("application/xml")
	public List<AirportInfo> deleteAirportInfoByCode(@PathParam("airportCode") String airportCode) {
		airportsByCodeMap.remove(airportCode);
		return new ArrayList<AirportInfo>(airportsByCodeMap.values());
	}

	/*
	 *   Get AirportInfo by airport code as JSON
	 */
	@GET
	@Path("/json/airports/")
	@Produces("application/json")
	public List<AirportInfo> getAirportInfosJSON() {
		return new ArrayList<AirportInfo>(airportsByCodeMap.values());
	}

	/*
	 *  Get AirportInfo by airport code as JSON
	 */
	@GET
	@Path("/json/airports/{airportCode}")
	@Produces("application/json")
	public AirportInfo getAirportInfoJSON(@PathParam("airportCode") String airportCode) {
		return airportsByCodeMap.get(airportCode);
	}

	@GET
	@Path("/hello")
	@Produces("text/plain")
	public String hello() {
		return "Hello, this is my first restful webservice";
	}

	@GET
	@Path("/message/{message}")
	@Produces("text/plain")
	public String showMsg(@PathParam("message") String message) {
		return message;
	}

	public static void fetchAirportInfos() {
		AirportInfo airportInfo1 = new AirportInfo();
		airportInfo1.setAirportCode("SFO");
		airportInfo1.setAirportName("San Francisco International");
		airportsByCodeMap.put(airportInfo1.getAirportCode(), airportInfo1);

		AirportInfo airportInfo2 = new AirportInfo();
		airportInfo2.setAirportCode("SAN");
		airportInfo2.setAirportName("San Diego International Airport");
		airportsByCodeMap.put(airportInfo2.getAirportCode(), airportInfo2);

		AirportInfo airportInfo3 = new AirportInfo();
		airportInfo3.setAirportCode("LCY");
		airportInfo3.setAirportName("London City Airport");
		airportsByCodeMap.put(airportInfo3.getAirportCode(), airportInfo3);

		AirportInfo airportInfo4 = new AirportInfo();
		airportInfo4.setAirportCode("ORY");
		airportInfo4.setAirportName("Paris Orly");
		airportsByCodeMap.put(airportInfo4.getAirportCode(), airportInfo4);

		AirportInfo airportInfo5 = new AirportInfo();
		airportInfo5.setAirportCode("MCO");
		airportInfo5.setAirportName("Orlando International");
		airportsByCodeMap.put(airportInfo5.getAirportCode(), airportInfo5);
	}

	static {
		fetchAirportInfos();
	}
}
