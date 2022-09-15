package com.online.request;

import java.util.Date;
import java.util.List;


public class SearchTheatreRequest {
    private final String movieName;
    private final String theatreName;
    private final String town;
    private final String locality;
    private final TheatreType type;
    private final String brand;
    private final List<String> facilities;
    private final Date date;

    private SearchTheatreRequest(Builder builder){

        this.date=builder.date;
        this.theatreName= builder.theatreName;
        this.movieName= builder.movieName;
        this.town=builder.town;
        this.locality= builder.locality;
        this.type=builder.type;
        this.brand= builder.brand;
        this.facilities=builder.facilities;
    }

    public static class Builder{
        private String movieName;
        private String theatreName;
        private  String town;
        private  String locality;
        private  TheatreType type;
        private  String brand;
        private  List<String> facilities;
        private Date date;

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Builder setMovieName(String movieName) {
            this.movieName = movieName;
            return this;
        }

        public Builder setTheatreName(String theatreName) {
            this.theatreName = theatreName;
            return this;
        }

        public Builder setTown(String town) {
            this.town = town;
            return this;
        }

        public Builder setLocality(String locality) {
            this.locality = locality;
            return this;
        }


        public Builder setType(TheatreType type) {
            this.type = type;
            return this;
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setFacilities(List<String> facilities) {
            this.facilities = facilities;
            return this;
        }

        public SearchTheatreRequest build() {
            return new SearchTheatreRequest(this);
        }
    }

    public String getMovieName() {
        return movieName;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public String getTown() {
        return town;
    }

    public String getLocality() {
        return locality;
    }

    public TheatreType getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public Date getDate() {
        return date;
    }
}
