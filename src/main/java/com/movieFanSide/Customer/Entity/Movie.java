package com.movieFanSide.Customer.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @Column(name = "movie_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieid;

    @Column(name = "image",length = 255)
    private String image;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "language", length = 255)
    private String language;

    @Column(name = "duration", length = 255)
    private String duration;

    @Column(name = "releaseDate", length = 25)
    private String releaseDate;

    public Movie(int movieid, String image, String title, String description,
                 String language, String duration, String releaseDate) {
        this.movieid = movieid;
        this.image = image;
        this.title = title;
        this.description = description;
        this.language = language;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    public Movie() {
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
