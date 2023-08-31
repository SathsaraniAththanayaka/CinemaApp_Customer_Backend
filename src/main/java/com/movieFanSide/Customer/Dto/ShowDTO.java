package com.movieFanSide.Customer.Dto;

import java.util.List;

public class ShowDTO {
    private int movieid;
    List<Theater> theaters;

    public ShowDTO(int movieid, List<Theater> theaters) {
        this.movieid = movieid;
        this.theaters = theaters;
    }

    public ShowDTO() {
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public List<Theater> getTheaters() {
        return theaters;
    }

    public void setTheaters(List<Theater> theaters) {
        this.theaters = theaters;
    }

    public static class Theater{
        private int theaterid;
        private String theaterName;

        private String theaterCity;

        List<Date> dates;

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

        public List<Date> getDates() {
            return dates;
        }

        public void setDates(List<Date> dates) {
            this.dates = dates;
        }
    }
    public static class Date{
        private String date;
        List<Time> times;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public List<Time> getTimes() {
            return times;
        }

        public void setTimes(List<Time> times) {
            this.times = times;
        }
    }

    public static class Time{
        private String time;
        private String scheduleid;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getScheduleid() {
            return scheduleid;
        }

        public void setScheduleid(String scheduleid) {
            this.scheduleid = scheduleid;
        }
    }


}
