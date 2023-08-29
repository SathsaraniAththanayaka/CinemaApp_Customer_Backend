package com.movieFanSide.Customer.Entity;

import javax.persistence.*;

@Entity
@Table(name = "theater")
public class Theater {

    @Id
    @Column(name = "theater_id",length = 45)
    private int theaterid;

//    @ManyToOne
//    @JoinColumn(name = "movie_id")
//    private Movie movie;

    @Column(name = "theater_name",length = 255)
    private String name;

    @Column(name = "theater_city",length = 255)
    private String city;

    public Theater(int theaterid, String name, String city) {
        this.theaterid = theaterid;
        this.name = name;
        this.city = city;
    }

    public Theater() {
    }

    public int getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(int theaterid) {
        this.theaterid = theaterid;
    }

//    public Movie getMovie() {
//        return movie;
//    }
//
//    public void setMovie(Movie movie) {
//        this.movie = movie;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
