package com.example.apple.project2;

public class CityBean {
    /**
     * name : Moscow
     * country : RU
     * lon : 37.6156
     * geoname_id : 524901
     * iso2 : RU
     * lat : 55.7522
     * type : city
     * population : 0
     */

    private String name;
    private String country;
    private double lon;
    private int geoname_id;
    private String iso2;
    private double lat;
    private String type;
    private int population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getGeoname_id() {
        return geoname_id;
    }

    public void setGeoname_id(int geoname_id) {
        this.geoname_id = geoname_id;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}