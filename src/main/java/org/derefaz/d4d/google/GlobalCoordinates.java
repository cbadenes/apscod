package org.derefaz.d4d.google;

public class GlobalCoordinates {

	private Coordinates northeast;
	private Coordinates southwest;
	public Coordinates getNortheast() {
		return northeast;
	}
	public Coordinates getSouthwest() {
		return southwest;
	}
	public void setNortheast(Coordinates northeast) {
		this.northeast = northeast;
	}
	public void setSouthwest(Coordinates southwest) {
		this.southwest = southwest;
	}
	@Override
	public String toString() {
		return "GlobalCoordinates [northeast=" + northeast + ", southwest="
				+ southwest + "]";
	}
	
}
