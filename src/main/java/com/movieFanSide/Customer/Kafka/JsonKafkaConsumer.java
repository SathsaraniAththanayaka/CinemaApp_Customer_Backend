package com.movieFanSide.Customer.Kafka;

import com.movieFanSide.Customer.Dto.BookingConfirmDTO;
import com.movieFanSide.Customer.Dto.BookingDTO;
import com.movieFanSide.Customer.Dto.MovieDTO;
import com.movieFanSide.Customer.Dto.SeatDTO;
import com.movieFanSide.Customer.Entity.SeatNo;
import com.movieFanSide.Customer.KafkaConsumerHandler.MoviePublishDTO;
import com.movieFanSide.Customer.KafkaConsumerHandler.SeatCategoryDTO;
import com.movieFanSide.Customer.KafkaConsumerHandler.ShowDTO;
import com.movieFanSide.Customer.Service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @Autowired
    private MovieService movieService;



    @KafkaListener(topics = "movie_json", groupId = "myGroup")
    public void consume(MovieDTO movieDTO){
//        MovieDTO.Cinema cinema = new MovieDTO.Cinema(
//                moviePublishDTO.getCinemaUser().getCinemaId(),
//                moviePublishDTO.getCinemaUser().getCinemaName(),
//                moviePublishDTO.getCinemaUser().getCity(),
//                moviePublishDTO.getCinemaUser().getPhoneNo()
//        );
//
//        List<ShowDTO> showDTOs = new ArrayList<>();
//        showDTOs = moviePublishDTO.getShows();
//
//        List<MovieDTO.Schedule> schedules = new ArrayList<>();
//
//        for (ShowDTO showDTO : showDTOs) {
//            List<SeatCategoryDTO> seatCategoryDTOS = new ArrayList<>();
//            seatCategoryDTOS = showDTO.getSeatCategoryDTO();
//            List<MovieDTO.SeatNo> seatNos = new ArrayList<>();
//            for(SeatCategoryDTO seatCategoryDTO : seatCategoryDTOS){
//                MovieDTO.SeatNo seatNo = new MovieDTO.SeatNo(
//                        seatCategoryDTO.getType(),
//                        seatCategoryDTO.getAvailableSeatCount()
//                );
//                seatNos.add(seatNo);
//            }
//            MovieDTO.Schedule schedule = new MovieDTO.Schedule(
//                    (int)showDTO.getShowID(),
//                    showDTO.getShowDate(),
//                    showDTO.getShowTime(),
//                    seatNos
//            );
//            schedules.add(schedule);
//        }
//            MovieDTO movieDTO = new MovieDTO(
//                    moviePublishDTO.getMovieID(),
//                    cinema,
//                    moviePublishDTO.getImgURL(),
//                    moviePublishDTO.getMovieName(),
//                    moviePublishDTO.getDescription(),
//                    moviePublishDTO.getLanguage(),
//                    moviePublishDTO.getDurationMinutes(),
//                    moviePublishDTO.getReleaseDate().toString(),
//                    schedules,
//                    moviePublishDTO.getSeats()
//            );
            movieService.addMovie(movieDTO);
            LOGGER.info(String.format("Message received -> %s", movieDTO.toString()));
    }

    @KafkaListener(topics = "bookings", groupId = "myGroup")
    public void consume(BookingDTO bookingDTO){
        LOGGER.info(String.format("Message received -> %s", bookingDTO.toString()));
    }

    @KafkaListener(topics = "bookings_Confirm", groupId = "myGroup")
    public void consume(BookingConfirmDTO bookingConfirmDTO){
        movieService.addConfirmedBooking(bookingConfirmDTO);
        LOGGER.info(String.format("Message received -> %s", bookingConfirmDTO.toString()));
    }
}

