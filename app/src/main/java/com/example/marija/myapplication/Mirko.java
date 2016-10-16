package com.example.marija.myapplication;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by marija on 15.10.16.
 */




@Generated("org.jsonschema2pojo")
public class Mirko {

    @SerializedName("ip")
    @Expose
    private String ip;
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("country_name")
    @Expose
    private String countryName;
    @SerializedName("region_code")
    @Expose
    private String regionCode;
    @SerializedName("region_name")
    @Expose
    private String regionName;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("zip_code")
    @Expose
    private String zipCode;
    @SerializedName("time_zone")
    @Expose
    private String timeZone;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("metro_code")
    @Expose
    private Integer metroCode;

    /**
     *
     * @return
     * The ip
     */
    public String getIp() {
        return ip;
    }

    /**
     *
     * @param ip
     * The ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     *
     * @return
     * The countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     *
     * @param countryCode
     * The country_code
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     *
     * @return
     * The countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     *
     * @param countryName
     * The country_name
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     *
     * @return
     * The regionCode
     */
    public String getRegionCode() {
        return regionCode;
    }

    /**
     *
     * @param regionCode
     * The region_code
     */
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    /**
     *
     * @return
     * The regionName
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     *
     * @param regionName
     * The region_name
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    /**
     *
     * @return
     * The city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     *
     * @param zipCode
     * The zip_code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     *
     * @return
     * The timeZone
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     *
     * @param timeZone
     * The time_zone
     */
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    /**
     *
     * @return
     * The latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude
     * The latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @return
     * The longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude
     * The longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * @return
     * The metroCode
     */
    public Integer getMetroCode() {
        return metroCode;
    }

    /**
     *
     * @param metroCode
     * The metro_code
     */
    public void setMetroCode(Integer metroCode) {
        this.metroCode = metroCode;
    }

}
