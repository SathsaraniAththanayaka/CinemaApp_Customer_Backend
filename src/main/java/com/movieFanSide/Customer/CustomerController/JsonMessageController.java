package com.movieFanSide.Customer.CustomerController;

import com.movieFanSide.Customer.Dto.BookingDTO;
import com.movieFanSide.Customer.Dto.MovieDTO;
import com.movieFanSide.Customer.Kafka.JsonKafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody MovieDTO movieDTO){
        kafkaProducer.sendMessage(movieDTO);
        return ResponseEntity.ok("Json Message sent to kafka topic -> movie");
    }

    @PostMapping("/bookings")
    public ResponseEntity<String> publish(@RequestBody BookingDTO bookingDTO){
        kafkaProducer.sendBookings(bookingDTO);
        return ResponseEntity.ok("Json Message sent to kafka topic -> bookings");
    }
}
