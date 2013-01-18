package org.derefaz.d4d.position;

import org.derefaz.d4d.google.Address;
import org.derefaz.d4d.google.AddressComponents;

public class PositionRow {

	private Integer id;
	private Double lng;
	private Double lat;
	private String adminAreaLevel2;
	private String adminAreaLevel1;
	private String country;
	
	private PositionRow(Builder builder) {
	  this.id = builder.id;
	  this.lng = builder.lng;
	  this.lat = builder.lat;
	  this.adminAreaLevel2 = builder.adminAreaLevel2;
	  this.adminAreaLevel1 = builder.adminAreaLevel1;
	  this.country = builder.country;
	}
	public static class Builder{
		private Integer id;
		private Double lng;
		private Double lat;
		private String adminAreaLevel2;
		private String adminAreaLevel1;
		private String country;
		public Builder withId(Integer id) {
		  this.id = id;
		  return this;
		}
		public Builder withLng(Double lng) {
		  this.lng = lng;
		  return this;
		}
		public Builder withLat(Double lat) {
		  this.lat = lat;
		  return this;
		}
		public Builder withAddress(Address address) {
			for (AddressComponents component : address.getAddress_components()) {
				if (component.getTypes().contains("administrative_area_level_1")){
					this.adminAreaLevel1 = component.getShort_name();
				}
				if (component.getTypes().contains("administrative_area_level_2")){
					this.adminAreaLevel2 = component.getShort_name();
				}
				if (component.getTypes().contains("country")){
					this.country = component.getShort_name();
				}
			}
		
		  return this;
		}
		public PositionRow build() {
		  return new PositionRow(this);
		}
		public Double getLng() {
			return lng;
		}
		public Double getLat() {
			return lat;
		}
	}
	public Integer getId() {
		return id;
	}
	public Double getLng() {
		return lng;
	}
	public Double getLat() {
		return lat;
	}
	public String getAdminAreaLevel2() {
		return this.adminAreaLevel2;
	}
	public String getAdminAreaLevel1() {
		return this.adminAreaLevel1;
	}
	public String getCountry() {
		return this.country;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminAreaLevel2 == null) ? 0 : adminAreaLevel2.hashCode());
		result = prime * result + ((adminAreaLevel1 == null) ? 0 : adminAreaLevel1.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lat == null) ? 0 : lat.hashCode());
		result = prime * result + ((lng == null) ? 0 : lng.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PositionRow other = (PositionRow) obj;
		if (adminAreaLevel2 == null) {
			if (other.adminAreaLevel2 != null)
				return false;
		} else if (!adminAreaLevel2.equals(other.adminAreaLevel2))
			return false;
		if (adminAreaLevel1 == null) {
			if (other.adminAreaLevel1 != null)
				return false;
		} else if (!adminAreaLevel1.equals(other.adminAreaLevel1))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lat == null) {
			if (other.lat != null)
				return false;
		} else if (!lat.equals(other.lat))
			return false;
		if (lng == null) {
			if (other.lng != null)
				return false;
		} else if (!lng.equals(other.lng))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PositionRow [id=" + id + ", lng=" + lng + ", lat=" + lat
				+ ", adminAreaLevel2=" + adminAreaLevel2 
				+ ", adminAreaLevel1=" + adminAreaLevel1
				+ ", country=" + country
				+ "]";
	}
	
	
		
}
