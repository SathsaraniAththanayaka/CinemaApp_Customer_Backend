package com.movieFanSide.Customer.Dto;

import java.util.List;
import java.util.Map;

public class MovieDTO {
    private int id;
    private String image;
    private String title;
    private String description;
    private String language;
    private String duration;
    private String releaseDate;
    private List<Theater> places;

    public MovieDTO(int id, String image, String title, String description, String language,
                    String duration, String releaseDate, List<Theater> places) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
        this.language = language;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.places = places;
    }

    public MovieDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Theater> getPlaces() {
        return places;
    }

    public void setPlaces(List<Theater> places) {
        this.places = places;
    }

    public static class Theater {
        private String name;
        private String city;
        private List<Schedule> schedule;

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

        public List<Schedule> getSchedule() {
            return schedule;
        }

        public void setSchedule(List<Schedule> schedule) {
            this.schedule = schedule;
        }
    }

    public static class Schedule {
        private String date;
        private List<String> times;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public List<String> getTimes() {
            return times;
        }

        public void setTimes(List<String> times) {
            this.times = times;
        }
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", duration='" + duration + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", places=" + places +
                '}';
    }
}

