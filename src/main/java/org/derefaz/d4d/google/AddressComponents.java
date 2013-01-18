package org.derefaz.d4d.google;

import java.util.List;

public class AddressComponents {

	private String long_name;
	private String short_name;
	private List<String> types;
	
	
	
	public String getLong_name() {
		return long_name;
	}
	public String getShort_name() {
		return short_name;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setLong_name(String long_name) {
		this.long_name = long_name.replace(" ", "_").replace("'", "_").replaceAll("\\?", "_");
	}
	public void setShort_name(String short_name) {
		this.short_name = short_name.replace(" ", "_").replace("'", "_").replaceAll("\\?", "_");
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	@Override
	public String toString() {
		return "AddressComponents [long_name=" + long_name + ", short_name="
				+ short_name + ", types=" + types + "]";
	}
	
	public static void main(String[] args) {
		String name = "carlos?m]artinez";
		System.out.println(name.replaceAll("\\?", "-").replaceAll("\\]", ""));
	}
	
}
