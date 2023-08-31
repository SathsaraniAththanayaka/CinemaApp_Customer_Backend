package com.movieFanSide.Customer.Kafka;

import com.movieFanSide.Customer.Dto.BookingDTO;
import com.movieFanSide.Customer.Dto.MovieDTO;
import com.movieFanSide.Customer.Service.CustomerService;
import com.movieFanSide.Customer.Service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @KafkaListener(topics = "booking_json", groupId = "myGroup")
    public void consume(BookingDTO bookingDTO){
        LOGGER.info(String.format("Message received -> %s", bookingDTO.toString()));
    }
}

