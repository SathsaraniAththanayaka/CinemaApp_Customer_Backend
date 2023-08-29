package com.movieFanSide.Customer.Dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class MovieDTO {


    private int theaterid;

    private String theaterName;

    private String theaterCity;

    private int movieid;
    private String image;
    private String title;
    private String description;
    private String language;
    private String duration;
    private String releaseDate;
    private List<Schedule> schedules;

    public MovieDTO(int movieid, int theaterid, String theaterName, String theaterCity,
                    String image, String title, String description, String language,
                    String duration, String releaseDate, List<Schedule> schedules) {
        this.movieid = movieid;
        this.theaterid = theaterid;
        this.theaterName = theaterName;
        this.theaterCity = theaterCity;
        this.image = image;
        this.title = title;
        this.description = description;
        this.language = language;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.schedules = schedules;
    }

    public MovieDTO() {
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

    public int getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(int theaterid) {
        this.theaterid = theaterid;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterCity() {
        return theaterCity;
    }

    public void setTheaterCity(String theaterCity) {
        this.theaterCity = theaterCity;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public static class Schedule {

        private int scheduleid;
        private String date;

        private String time;
        private List<SeatNo> seats;

        public int getScheduleid() {
            return scheduleid;
        }

        public void setScheduleid(int scheduleid) {
            this.scheduleid = scheduleid;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public List<SeatNo> getSeats() {
            return seats;
        }

        public void setSeats(List<SeatNo> seats) {
            this.seats = seats;
        }
    }

    public static class SeatNo{
        private int availabilityid;
        private String category;

        private int seatNo;

        public int getAvailabilityid() {
            return availabilityid;
        }

        public void setAvailabilityid(int availabilityid) {
            this.availabilityid = availabilityid;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getSeatNo() {
            return seatNo;
        }

        public void setSeatNo(int seatNo) {
            this.seatNo = seatNo;
        }
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieid=" + movieid +
                ", theaterid=" + theaterid +
                ", theaterName='" + theaterName + '\'' +
                ", theaterCity='" + theaterCity + '\'' +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", duration='" + duration + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", schedules=" + schedules +
                '}';
    }
}

