package com.cwctravel.rest.api.info;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "airportInfos")
public class AirportInfo {
	String airportCode;
	String airportName;

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

}
