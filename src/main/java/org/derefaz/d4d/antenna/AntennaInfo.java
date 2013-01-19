package org.derefaz.d4d.antenna;

public class AntennaInfo {

    private final String id;
    private final String lat;
    private final String lng;
    private final String adminArea2;
    private final String adminArea1;
    private final String country;

    private AntennaInfo(Builder builder) {
        this.id = builder.id;
        this.lat = builder.lat;
        this.lng = builder.lng;
        this.adminArea2 = builder.adminArea2;
        this.adminArea1 = builder.adminArea1;
        this.country = builder.country;
    }

    public static class Builder {

        private String id;
        private String lat;
        private String lng;
        private String adminArea2;
        private String adminArea1;
        private String country;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withLat(String lat) {
            this.lat = lat;
            return this;
        }

        public Builder withLng(String lng) {
            this.lng = lng;
            return this;
        }

        public Builder withAdminArea2(String adminArea2) {
            this.adminArea2 = adminArea2;
            return this;
        }

        public Builder withAdminArea1(String adminArea1) {
            this.adminArea1 = adminArea1;
            return this;
        }

        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        public AntennaInfo build() {
            validate();
            return new AntennaInfo(this);
        }

        private void validate() {
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((adminArea1 == null) ? 0 : adminArea1.hashCode());
        result = prime * result + ((adminArea2 == null) ? 0 : adminArea2.hashCode());
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
        AntennaInfo other = (AntennaInfo) obj;
        if (adminArea1 == null) {
            if (other.adminArea1 != null)
                return false;
        } else if (!adminArea1.equals(other.adminArea1))
            return false;
        if (adminArea2 == null) {
            if (other.adminArea2 != null)
                return false;
        } else if (!adminArea2.equals(other.adminArea2))
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
        return "AntennaInfo [id=" + id + ", lat=" + lat + ", lng=" + lng + ", adminArea2=" + adminArea2
                + ", adminArea1=" + adminArea1 + ", country=" + country + "]";
    }

    /**
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return the lat
     */
    public String getLat() {
        return this.lat;
    }

    /**
     * @return the lng
     */
    public String getLng() {
        return this.lng;
    }

    /**
     * @return the adminArea2
     */
    public String getAdminArea2() {
        return this.adminArea2;
    }

    /**
     * @return the adminArea1
     */
    public String getAdminArea1() {
        return this.adminArea1;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return this.country;
    }

}
