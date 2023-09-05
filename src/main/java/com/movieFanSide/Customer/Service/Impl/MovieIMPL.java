package com.movieFanSide.Customer.Service.Impl;

import com.movieFanSide.Customer.Dto.BookingConfirmDTO;
import com.movieFanSide.Customer.Dto.MovieDTO;
import com.movieFanSide.Customer.Entity.*;
import com.movieFanSide.Customer.Repo.*;
import com.movieFanSide.Customer.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private PriceRepo priceRepo;

    @Autowired
    private ConfirmedBookingRepo confirmedBookingRepo;


    @Override
    public String addMovie(MovieDTO movieDTO) {
        Movie movie = movieRepo.findByTitle(movieDTO.getMovieName());
        if(movie == null){
            Movie movie1 = new Movie(
                    movieDTO.getMovieid(),
                    movieDTO.getImgURL(),
                    movieDTO.getMovieName(),
                    movieDTO.getDescription(),
                    movieDTO.getLanguage(),
                    Integer.toString(movieDTO.getDurationMinutes()),
                    movieDTO.getReleaseDate()
            );
            movieRepo.save(movie1);
            movie = movie1;
        }


        Theater theater = new Theater(
                movieDTO.getCinemaUser().getCinemaId(),
                movieDTO.getCinemaUser().getCinemaName(),
                movieDTO.getCinemaUser().getCity()
        );

        theaterRepo.save(theater);

        Map<String, Double> seatPrices = movieDTO.getSeats();

        if (seatPrices != null && !seatPrices.isEmpty()) {
            for (Map.Entry<String, Double> entry : seatPrices.entrySet()) {
                String seatCategory = entry.getKey();
                Double price = entry.getValue();


                Price priceEntity = new Price();
                priceEntity.setTheater(theater); // You should have the 'theater' object already


                priceEntity.setSeatCategory(seatCategory);
                priceEntity.setPrice(price);


                priceRepo.save(priceEntity);
            }
        }
        List<MovieDTO.Schedule> schedules = new ArrayList<>();
        schedules= movieDTO.getShows();
        for (MovieDTO.Schedule schedule : schedules) {
            Schedule schedule1 = new Schedule(
                    schedule.getShowID(),
                    theater,
                    movie,
                    schedule.getShowDate(),
                    schedule.getShowTime()

            );
            scheduleRepo.save(schedule1);

            List<MovieDTO.SeatNo> seatNos = new ArrayList<>();
            seatNos= schedule.getSeatCategoryDTO();

            for(MovieDTO.SeatNo seatNo:seatNos){
                SeatNo seatNo1 = new SeatNo(
                        seatNo.getAvailabilityid(),
                        schedule1,
                        seatNo.getType(),
                        seatNo.getAvailableSeatCount()
                );
                seatRepo.save(seatNo1);
            }

        }
        return movieDTO.getMovieName();

    }

    @Override
    public void addConfirmedBooking(BookingConfirmDTO bookingConfirmDTO) {
        ConfirmedBookings confirmedBookings = new ConfirmedBookings(
                bookingConfirmDTO.getBookingID(),
                bookingConfirmDTO.getCustomerID(),
                bookingConfirmDTO.getNoOfBookedSeats(),
                bookingConfirmDTO.getMessage()
        );
        confirmedBookingRepo.save(confirmedBookings);
    }


}
