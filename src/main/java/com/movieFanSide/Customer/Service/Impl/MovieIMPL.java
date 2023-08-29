package com.movieFanSide.Customer.Service.Impl;

import com.movieFanSide.Customer.Dto.MovieDTO;
import com.movieFanSide.Customer.Entity.Movie;
import com.movieFanSide.Customer.Entity.Schedule;
import com.movieFanSide.Customer.Entity.SeatNo;
import com.movieFanSide.Customer.Entity.Theater;
import com.movieFanSide.Customer.Repo.*;
import com.movieFanSide.Customer.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieIMPL implements MovieService {

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private TheaterRepo theaterRepo;

    @Autowired
    private ScheduleRepo scheduleRepo;

    @Autowired
    private SeatRepo seatRepo;


    @Override
    public String addMovie(MovieDTO movieDTO) {
        Movie movie = movieRepo.findByTitle(movieDTO.getTitle());
        if(movie == null){
            Movie movie1 = new Movie(
                    movieDTO.getMovieid(),
                    movieDTO.getImage(),
                    movieDTO.getTitle(),
                    movieDTO.getDescription(),
                    movieDTO.getLanguage(),
                    movieDTO.getDuration(),
                    movieDTO.getReleaseDate()
            );
            movieRepo.save(movie1);
            movie = movie1;
        }


        Theater theater = new Theater(
                movieDTO.getTheaterid(),
                movieDTO.getTheaterName(),
                movieDTO.getTheaterCity()
        );

        theaterRepo.save(theater);
        List<MovieDTO.Schedule> schedules = new ArrayList<>();
        schedules= movieDTO.getSchedules();
        for (MovieDTO.Schedule schedule : schedules) {
            Schedule schedule1 = new Schedule(
                    schedule.getScheduleid(),
                    theater,
                    movie,
                    schedule.getDate(),
                    schedule.getTime()

            );
            scheduleRepo.save(schedule1);

            List<MovieDTO.SeatNo> seatNos = new ArrayList<>();
            seatNos= schedule.getSeats();

            for(MovieDTO.SeatNo seatNo:seatNos){
                SeatNo seatNo1 = new SeatNo(
                        seatNo.getAvailabilityid(),
                        schedule1,
                        seatNo.getCategory(),
                        seatNo.getSeatNo()
                );
                seatRepo.save(seatNo1);
            }

        }
        return movieDTO.getTitle();

    }
}
