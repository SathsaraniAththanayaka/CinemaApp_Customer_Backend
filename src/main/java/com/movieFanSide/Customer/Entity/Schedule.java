package com.movieFanSide.Customer.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @Column(name = "schedule_id",length = 45)
    private int scheduleid;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "date",length = 45)
    private String date;
//    @ElementCollection
//    @CollectionTable(name = "schedule_time", joinColumns = @JoinColumn(name = "schedule_id"))
    @Column(name = "time",length = 45)
    //private List<String> times;
    private String time;

    public Schedule(int scheduleid, Theater theater,Movie movie, String date, String time) {
        this.scheduleid = scheduleid;
        this.theater = theater;
        this.movie = movie;
        this.date = date;
        this.time = time;
    }

    public Schedule() {
    }

    public int getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(int scheduleid) {
        this.scheduleid = scheduleid;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
