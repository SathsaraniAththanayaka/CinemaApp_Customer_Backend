package com.movieFanSide.Customer.Dto;

public class MovieDetailsDTO {
    private int movieid;
    private String image;
    private String title;
    private String description;
    private String language;
    private String duration;
    private String releaseDate;

    public MovieDetailsDTO(int movieid, String image, String title, String description, String language,
                           String duration, String releaseDate) {
        this.movieid = movieid;
        this.image = image;
        this.title = title;
        this.description = description;
        this.language = language;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    public MovieDetailsDTO() {
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
