package com.movieFanSide.Customer.Dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class MovieDTO {


    private Cinema cinemaUser;

    private int movieid;
    private String imgURL;
    private String movieName;
    private String description;
    private String language;
    private int durationMinutes;
    private String releaseDate;
    private List<Schedule> shows;
    private Map<String, Double> seats;

    public MovieDTO(int movieid, Cinema cinemaUser,
                    String imgURL, String movieName, String description, String language,
                    int durationMinutes, String releaseDate, List<Schedule> shows, Map<String, Double> seats) {
        this.movieid = movieid;
        this.cinemaUser = cinemaUser;
        this.imgURL = imgURL;
        this.movieName = movieName;
        this.description = description;
        this.language = language;
        this.durationMinutes = durationMinutes;
        this.releaseDate = releaseDate;
        this.shows = shows;
        this.seats = seats;
    }

    public MovieDTO() {
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    public List<Schedule> getShows() {
        return shows;
    }

    public void setShows(List<Schedule> shows) {
        this.shows = shows;
    }

    public Cinema getCinemaUser() {
        return cinemaUser;
    }

    public void setCinemaUser(Cinema cinemaUser) {
        this.cinemaUser = cinemaUser;
    }

    public Map<String, Double> getSeats() {
        return seats;
    }

    public void setSeats(Map<String, Double> seats) {
        this.seats = seats;
    }

    public static class Cinema{
        private int cinemaId;
        private String cinemaName;

        private String city;
        private String phoneNo;

        public Cinema(int cinemaId, String cinemaName, String city, String phoneNo) {
            this.cinemaId = cinemaId;
            this.cinemaName = cinemaName;
            this.city = city;
            this.phoneNo = phoneNo;
        }

        public Cinema() {
        }

        public int getCinemaId() {
            return cinemaId;
        }

        public void setCinemaId(int cinemaId) {
            this.cinemaId = cinemaId;
        }

        public String getCinemaName() {
            return cinemaName;
        }

        public void setCinemaName(String cinemaName) {
            this.cinemaName = cinemaName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }
    }

    public static class Schedule {

        private int showID;
        private String showDate;

        private String showTime;
        private List<SeatNo> seatCategoryDTO;

        public Schedule(int showID, String showDate, String showTime, List<SeatNo> seatCategoryDTO) {
            this.showID = showID;
            this.showDate = showDate;
            this.showTime = showTime;
            this.seatCategoryDTO = seatCategoryDTO;
        }

        public Schedule() {
        }

        public int getShowID() {
            return showID;
        }

        public void setShowID(int showID) {
            this.showID = showID;
        }

        public String getShowDate() {
            return showDate;
        }

        public void setShowDate(String showDate) {
            this.showDate = showDate;
        }

        public String getShowTime() {
            return showTime;
        }

        public void setShowTime(String showTime) {
            this.showTime = showTime;
        }

        public List<SeatNo> getSeatCategoryDTO() {
            return seatCategoryDTO;
        }

        public void setSeatCategoryDTO(List<SeatNo> seatCategoryDTO) {
            this.seatCategoryDTO = seatCategoryDTO;
        }
    }

    public static class SeatNo{
        private int availabilityid;
        private String type;

        private int availableSeatCount;

        public SeatNo(String type, int availableSeatCount) {
            this.type = type;
            this.availableSeatCount = availableSeatCount;
        }

        public SeatNo() {
        }

        public int getAvailabilityid() {
            return availabilityid;
        }

        public void setAvailabilityid(int availabilityid) {
            this.availabilityid = availabilityid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getAvailableSeatCount() {
            return availableSeatCount;
        }

        public void setAvailableSeatCount(int availableSeatCount) {
            this.availableSeatCount = availableSeatCount;
        }
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieid=" + movieid +
                ", image='" + imgURL + '\'' +
                ", title='" + movieName + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", duration='" + durationMinutes + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", schedules=" + shows +
                '}';
    }
}

