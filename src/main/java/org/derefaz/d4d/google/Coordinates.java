package org.derefaz.d4d.google;

public class Coordinates {

	private Double lat;
	private Double lng;
	public Double getLat() {
		return lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	@Override
	public String toString() {
		return "Coordinates [lat=" + lat + ", lng=" + lng + "]";
	}
	
}
