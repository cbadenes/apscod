package org.derefaz.d4d.google;

import java.util.List;

public class Address {

	List<AddressComponents> address_components;
	String formatted_address;
	Geometry geometry;
	List<String> types;
	
	
	public List<AddressComponents> getAddress_components() {
		return address_components;
	}
	public String getFormatted_address() {
		return formatted_address;
	}
	public Geometry getGeometry() {
		return geometry;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setAddress_components(List<AddressComponents> address_components) {
		this.address_components = address_components;
	}
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	@Override
	public String toString() {
		return "Address [address_components=" + address_components
				+ ", formatted_address=" + formatted_address + ", geometry="
				+ geometry + ", types=" + types + "]";
	}
}
