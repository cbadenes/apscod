package org.derefaz.d4d.google;

public class Geometry {

	private GlobalCoordinates bounds;
	private Coordinates location;
	private String location_type;
	private GlobalCoordinates viewport;
	public GlobalCoordinates getBounds() {
		return bounds;
	}
	public Coordinates getLocation() {
		return location;
	}
	public String getLocation_type() {
		return location_type;
	}
	public GlobalCoordinates getViewport() {
		return viewport;
	}
	public void setBounds(GlobalCoordinates bounds) {
		this.bounds = bounds;
	}
	public void setLocation(Coordinates location) {
		this.location = location;
	}
	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}
	public void setViewport(GlobalCoordinates viewport) {
		this.viewport = viewport;
	}
	@Override
	public String toString() {
		return "Geometry [bounds=" + bounds + ", location=" + location
				+ ", location_type=" + location_type + ", viewport=" + viewport
				+ "]";
	}
}
