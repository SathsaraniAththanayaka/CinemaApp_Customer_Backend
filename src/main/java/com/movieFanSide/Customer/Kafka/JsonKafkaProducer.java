package com.movieFanSide.Customer.Kafka;

import com.movieFanSide.Customer.Dto.BookingConfirmDTO;
import com.movieFanSide.Customer.Dto.BookingDTO;
import com.movieFanSide.Customer.Dto.MovieDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, MovieDTO> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, MovieDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(MovieDTO movieDTO){
            LOGGER.info(String.format("Message sent -> %s", movieDTO.toString()));
            Message<MovieDTO> message = MessageBuilder
                    .withPayload(movieDTO)
                    .setHeader(KafkaHeaders.TOPIC, "movie_json")
                    .build();

            kafkaTemplate.send(message);


    }

    public void sendBookings(BookingDTO bookingDTO){
        LOGGER.info(String.format("Message sent -> %s", bookingDTO.toString()));
        Message<BookingDTO> message = MessageBuilder
                .withPayload(bookingDTO)
                .setHeader(KafkaHeaders.TOPIC, "booking_json")
                .build();

        kafkaTemplate.send(message);


    }

    public void sendBookingsConfirm(BookingConfirmDTO bookingConfirmDTO){
        LOGGER.info(String.format("Message sent -> %s", bookingConfirmDTO.toString()));
        Message<BookingConfirmDTO> message = MessageBuilder
                .withPayload(bookingConfirmDTO)
                .setHeader(KafkaHeaders.TOPIC, "bookings_Confirm")
                .build();

        kafkaTemplate.send(message);


    }
}
