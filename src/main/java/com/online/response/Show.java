package com.online.response;

import com.online.entity.MoviesDAO;
import com.online.entity.ShowDAO;
import com.online.request.ShowType;
import com.online.request.YesOrNo;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

public class Show {
    private long id;
    private String name;
    private ShowType type;
    private Theatre theatre;
    private double rating;
    private List<String> genre;
    private String language;
    private String format;
    private String ticketClass;
    private double price;
    private String currency;
    private YesOrNo seatsAvailability;
    private Integer availableSeats;
    private Date date;
    private Date showTime;

    public Show(ShowDAO showDAO){
        this.id=showDAO.getId();
        this.name=showDAO.getMovie().getName().concat(showDAO.getShowTime().toString());
        this.language= showDAO.getLanguage();
        this.genre=showDAO.getGenre();
        this.type=showDAO.getShowType();
        this.theatre=new Theatre(showDAO.getTheatre());
        this.rating=showDAO.getMovie().getRating();
        this.format=showDAO.getFormat();
        this.ticketClass=showDAO.getTicketClass();
        this.price=showDAO.getPrice();
        this.currency=showDAO.getCurrency();
        this.seatsAvailability=showDAO.getSeatsAvailability();
        this.availableSeats=showDAO.getAvailableTickets();
        this.date=showDAO.getDate();
        this.showTime=showDAO.getShowTime();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShowType getType() {
        return type;
    }

    public void setType(ShowType type) {
        this.type = type;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public YesOrNo getSeatsAvailability() {
        return seatsAvailability;
    }

    public void setSeatsAvailability(YesOrNo seatsAvailability) {
        this.seatsAvailability = seatsAvailability;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }
}
