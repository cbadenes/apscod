package org.derefaz.d4d.google;

import java.util.List;

import org.derefaz.d4d.position.Distance;

public class LocationResponse {

	private List<Address> results;
	private String status;
	
	public Address getMinimun(Coordinates _coordinates){
		Address minAddress = null;
		Double distance = Double.MAX_VALUE;
		
		for (Address address : this.results) {
			Coordinates addLocation = address.getGeometry().getLocation();
			double currentDistance = Distance.calculate(_coordinates.getLat(), _coordinates.getLng(), addLocation.getLat(), addLocation.getLng());
			if (currentDistance < distance){
				distance = currentDistance;
				minAddress = address;
			}
		}
		return minAddress;
	}
	
	public List<Address> getResults() {
		return results;
	}
	public String getStatus() {
		return status;
	}
	public void setResults(List<Address> results) {
		this.results = results;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LocationResponse [results=" + results + ", status=" + status
				+ "]";
	}
}
