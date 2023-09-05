package com.movieFanSide.Customer.Kafka;

import com.movieFanSide.Customer.Dto.BookingConfirmDTO;
import com.movieFanSide.Customer.Dto.BookingDTO;
import com.movieFanSide.Customer.Dto.MovieDTO;
import com.movieFanSide.Customer.Service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @Autowired
    private MovieService movieService;



    @KafkaListener(topics = "movie_json", groupId = "myGroup")
    public void consume(MovieDTO movieDTO){
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

