package com.movieFanSide.Customer.Kafka;

import com.movieFanSide.Customer.Dto.MovieDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, MovieDTO> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, MovieDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(List<MovieDTO> movieDTOList){
        for (MovieDTO movieDTO : movieDTOList) {
            LOGGER.info(String.format("Message sent -> %s", movieDTO.toString()));
            Message<MovieDTO> message = MessageBuilder
                    .withPayload(movieDTO)
                    .setHeader(KafkaHeaders.TOPIC, "movie_json")
                    .build();

            kafkaTemplate.send(message);
        }

    }
}
