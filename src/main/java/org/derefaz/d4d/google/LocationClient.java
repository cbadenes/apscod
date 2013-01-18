package org.derefaz.d4d.google;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

public class LocationClient {

	private static final String LOCATION_ENDPOINT = "http://maps.google.com/maps/api/geocode/json";
	
	public static LocationResponse request(Coordinates _coordinates) throws Exception{
		ClientRequest req = new ClientRequest(LOCATION_ENDPOINT);
	
		req.queryParameter("latlng", _coordinates.getLat()+","+_coordinates.getLng()).queryParameter("sensor", "false");
		System.out.println("requesting " + req);
		ClientResponse<LocationResponse> res = req.get(LocationResponse.class);
		return(res.getEntity());
	}
	
	public static void main(String[] args) throws Exception {
		Coordinates coordinates = new Coordinates();
		coordinates.setLat(new Double("7.182663"));
		coordinates.setLng(new Double("-3.366372"));
		System.out.println(LocationClient.request(coordinates ));
	}
}