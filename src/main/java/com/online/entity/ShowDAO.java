package com.online.entity;

import com.online.request.ShowType;
import com.online.request.YesOrNo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Show")
public class ShowDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="movie_id"))
    private MoviesDAO movie;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "theatre_id"))
    private TheatreDAO theatre;

    @JoinColumn(name = "town")
    private String town;

    @Column(name = "date")
    private Date date;

    @Column(name = "show_time")
    private Date showTime;

    @Column(name = "show_format")
    private String format;

    @Column(name = "show_type")
    private ShowType showType;

    @Column(name = "language")
    private String language;

    @Column(name = "genre")
    private List<String> genre;

    @Column(name = "ticket_class")
    private String ticketClass;

    @Column(name = "price")
    private double price;

    @Column(name = "currency")
    private String currency;

    @Column(name = "seats_availability")
    private YesOrNo seatsAvailability;

    @Column(name = "available_tickets")
    private Integer availableTickets;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MoviesDAO getMovie() {
        return movie;
    }

    public void setMovie(MoviesDAO movie) {
        this.movie = movie;
    }

    public TheatreDAO getTheatre() {
        return theatre;
    }

    public void setTheatre(TheatreDAO theatre) {
        this.theatre = theatre;
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

    public Integer getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(Integer availableTickets) {
        this.availableTickets = availableTickets;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public ShowType getShowType() {
        return showType;
    }

    public void setShowType(ShowType showType) {
        this.showType = showType;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
